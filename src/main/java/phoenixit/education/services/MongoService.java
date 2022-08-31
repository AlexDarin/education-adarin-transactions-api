package phoenixit.education.services;

import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

public interface MongoService {

    ModelResponse createModel(ModelRequest modelRequest) throws Throwable;

    ModelResponse getModel(String modelId) throws Throwable;

    ModelResponse updateModel(ModelRequest modelRequest) throws Throwable;

    void deleteModel(String modelId) throws Throwable;
}
