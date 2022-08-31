package phoenixit.education.httpClients.mongo;

import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

public interface MongoHttpClient {

    ModelResponse createModel(ModelRequest modelRequest) throws Throwable;

    ModelResponse getModel(String modelId) throws Throwable;

    ModelResponse updateModel(ModelRequest modelRequest) throws Throwable;

    void deleteModel(String modelId) throws Throwable;

}
