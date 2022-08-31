package phoenixit.education.httpClients.neo4j;

import phoenixit.education.models.ClassNode;

public interface Neo4jHttpClassClient {

    ClassNode create(ClassNode classNode) throws Throwable;

    ClassNode get(Long classNodeId) throws Throwable;

    ClassNode findByMongoId(String mongoId) throws Throwable;

    ClassNode getByLinkedModelNodeId(Long modelNodeId) throws Throwable;

    ClassNode update(ClassNode classNode) throws Throwable;

    void delete(Long classNodeId) throws Throwable;
}
