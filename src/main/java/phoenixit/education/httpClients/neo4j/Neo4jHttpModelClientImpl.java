package phoenixit.education.httpClients.neo4j;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoenixit.education.models.ModelNode;

@RequiredArgsConstructor
@Service
public class Neo4jHttpModelClientImpl implements Neo4jHttpModelClient {

    private final JsonRpcHttpClient neo4jModelClient;

    @Override
    public ModelNode create(ModelNode modelNode) throws Throwable {
        return neo4jModelClient.invoke("create", new Object[]{modelNode}, ModelNode.class);
    }

    @Override
    public ModelNode get(Long modelNodeId) throws Throwable {
        return neo4jModelClient.invoke("get", new Object[]{modelNodeId}, ModelNode.class);
    }

    @Override
    public ModelNode findByMongoId(String mongoId) throws Throwable {
        return neo4jModelClient.invoke("findByMongoId", new Object[]{mongoId}, ModelNode.class);
    }

    @Override
    public ModelNode update(ModelNode modelNode) throws Throwable {
        return neo4jModelClient.invoke("update", new Object[]{modelNode}, ModelNode.class);
    }

    @Override
    public void delete(Long modelNodeId) throws Throwable {
        neo4jModelClient.invoke("delete", new Object[]{modelNodeId});
    }

    @Override
    public void linkToClass(Long modelNodeId, Long classNodeId) throws Throwable {
        neo4jModelClient.invoke("linkToClass", new Object[]{modelNodeId, classNodeId});
    }
}
