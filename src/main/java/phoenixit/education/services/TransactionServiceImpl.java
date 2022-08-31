package phoenixit.education.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import phoenixit.education.components.ClassMapper;
import phoenixit.education.components.ModelMapper;
import phoenixit.education.httpClients.mongo.MongoHttpClient;
import phoenixit.education.httpClients.neo4j.Neo4jHttpClassClient;
import phoenixit.education.httpClients.neo4j.Neo4jHttpModelClient;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelCard;
import phoenixit.education.models.ModelNode;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final MongoHttpClient mongoClient;

    private final Neo4jHttpModelClient neo4jModelClient;

    private final Neo4jHttpClassClient neo4jClassClient;

    private final ModelMapper modelMapper;

    private final ClassMapper classMapper;

    @Override
    @Transactional
    public ModelCard create(final ModelRequest modelRequest, final Long classNodeId) throws Throwable {
        final ModelResponse modelResponse = mongoClient.createModel(modelRequest);
        final ModelNode modelNode = neo4jModelClient.create(modelMapper.responseToNode(modelResponse));

        final ModelCard modelCard = modelMapper.responseToCard(modelResponse);
        if (Objects.nonNull(classNodeId)) {
            neo4jModelClient.linkToClass(modelNode.getId(), classNodeId);
            modelCard.setClassInfo(classMapper.toInfo(neo4jClassClient.get(classNodeId)));
        }
        return modelCard;
    }

    @Override
    @Transactional
    public ModelCard update(ModelRequest modelRequest) throws Throwable {
        final ModelResponse modelResponse = mongoClient.updateModel(modelRequest);

        Long modelNodeId = Optional.ofNullable(neo4jModelClient.findByMongoId(modelRequest.getId()))
                .map(ModelNode::getId)
                .orElse(null);
        ModelNode modelNode = modelMapper.responseToNode(modelResponse);
        modelNode.setId(modelNodeId);
        modelNode = neo4jModelClient.update(modelNode);

        final ModelCard modelCard = modelMapper.responseToCard(modelResponse);
        final ClassNode classNode = neo4jClassClient.getByLinkedModelNodeId(modelNode.getId());
        if (Objects.nonNull(classNode)) {
            modelCard.setClassInfo(classMapper.toInfo(classNode));
        }
        return modelCard;
    }

    @Override
    @Transactional
    public void deleteById(String id) throws Throwable {
        mongoClient.deleteModel(id);
        ModelNode modelNode = neo4jModelClient.findByMongoId(id);
        if (Objects.nonNull(modelNode)) {
            neo4jModelClient.delete(modelNode.getId());
        }
    }

    @Override
    public ModelCard fetchById(String id) throws Throwable {
        final ModelResponse modelResponse = mongoClient.getModel(id);
        final ModelNode modelNode = neo4jModelClient.findByMongoId(modelResponse.getId());

        final ModelCard modelCard = modelMapper.responseToCard(modelResponse);
        final ClassNode classNode = neo4jClassClient.getByLinkedModelNodeId(modelNode.getId());
        if (Objects.nonNull(classNode)) {
            modelCard.setClassInfo(classMapper.toInfo(classNode));
        }
        return modelCard;
    }
}
