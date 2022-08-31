package phoenixit.education.httpClients.neo4j;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoenixit.education.models.ClassNode;

@RequiredArgsConstructor
@Service
public class Neo4jHttpClassClientImpl implements Neo4jHttpClassClient {

    private final JsonRpcHttpClient neo4jClassClient;

    @Override
    public ClassNode create(ClassNode classNode) throws Throwable {
        return neo4jClassClient.invoke("create", new Object[]{classNode}, ClassNode.class);
    }

    @Override
    public ClassNode get(Long classNodeId) throws Throwable {
        return neo4jClassClient.invoke("get", new Object[]{classNodeId}, ClassNode.class);
    }

    @Override
    public ClassNode findByMongoId(String mongoId) throws Throwable {
        return neo4jClassClient.invoke("findByMongoId", new Object[]{mongoId}, ClassNode.class);
    }

    @Override
    public ClassNode getByLinkedModelNodeId(Long modelNodeId) throws Throwable {
        return neo4jClassClient.invoke("getByLinkedModelNodeId", new Object[]{modelNodeId}, ClassNode.class);
    }

    @Override
    public ClassNode update(ClassNode classNode) throws Throwable {
        return neo4jClassClient.invoke("update", new Object[]{classNode}, ClassNode.class);
    }

    @Override
    public void delete(Long classNodeId) throws Throwable {
        neo4jClassClient.invoke("delete", new Object[]{classNodeId});
    }
}
