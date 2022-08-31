package phoenixit.education.services;

import phoenixit.education.models.ClassNode;
import phoenixit.education.models.ModelNode;

public interface Neo4jService {

    ModelNode createModelNode(ModelNode modelNode) throws Throwable;

    ModelNode getModelNode(Long modelNodeId) throws Throwable;

    ModelNode updateModelNode(ModelNode modelNode) throws Throwable;

    void deleteModelNode(Long modelNodeId) throws Throwable;

    ModelNode findModelNodeByMongoId(String mongoId) throws Throwable;

    ClassNode createClassNode(ClassNode classNode) throws Throwable;

    ClassNode getClassNode(Long classNodeId) throws Throwable;

    ClassNode updateClassNode(ClassNode classNode) throws Throwable;

    void deleteClassNode(Long classNodeId) throws Throwable;

    ClassNode findClassNodeByMongoId(String mongoId) throws Throwable;
}
