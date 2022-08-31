package phoenixit.education.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoenixit.education.httpClients.neo4j.Neo4jHttpClassClient;
import phoenixit.education.httpClients.neo4j.Neo4jHttpModelClient;
import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

@RequiredArgsConstructor
@Service
public class Neo4jServiceImpl implements Neo4jService {

    private final Neo4jHttpModelClient modelClient;

    private final Neo4jHttpClassClient classClient;


    @Override
    public ModelNode createModelNode(ModelNode modelNode) throws Throwable {
        return modelClient.create(modelNode);
    }

    @Override
    public ModelNode getModelNode(Long modelNodeId) throws Throwable {
        return modelClient.get(modelNodeId);
    }

    @Override
    public ModelNode updateModelNode(ModelNode modelNode) throws Throwable {
        return modelClient.update(modelNode);
    }

    @Override
    public void deleteModelNode(Long modelNodeId) throws Throwable {
        modelClient.delete(modelNodeId);
    }

    @Override
    public ModelNode findModelNodeByMongoId(String mongoId) throws Throwable {
        return modelClient.findByMongoId(mongoId);
    }

    @Override
    public ClassNode createClassNode(ClassNode classNode) throws Throwable {
        return classClient.create(classNode);
    }

    @Override
    public ClassNode getClassNode(Long classNodeId) throws Throwable {
        return classClient.get(classNodeId);
    }

    @Override
    public ClassNode updateClassNode(ClassNode classNode) throws Throwable {
        return classClient.update(classNode);
    }

    @Override
    public void deleteClassNode(Long classNodeId) throws Throwable {
        classClient.delete(classNodeId);
    }

    @Override
    public ClassNode findClassNodeByMongoId(String mongoId) throws Throwable {
        return classClient.findByMongoId(mongoId);
    }
}
