package phoenixit.education.httpClients.neo4j;

import phoenixit.education.models.ModelNode;

public interface Neo4jHttpModelClient {

    ModelNode create(ModelNode modelNode) throws Throwable;

    ModelNode get(Long modelNodeId) throws Throwable;

    ModelNode findByMongoId(String mongoId) throws Throwable;

    ModelNode update(ModelNode modelNode) throws Throwable;

    void delete(Long modelNodeId) throws Throwable;

    void linkToClass(Long modelNodeId, Long classNodeId) throws Throwable;
}
