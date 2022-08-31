package phoenixit.education.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoenixit.education.httpClients.mongo.MongoHttpClient;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

@RequiredArgsConstructor
@Service
public class MongoServiceImpl implements MongoService {

    private final MongoHttpClient mongoHttpClient;

    @Override
    public ModelResponse createModel(final ModelRequest modelRequest) throws Throwable {
        return mongoHttpClient.createModel(modelRequest);
    }

    @Override
    public ModelResponse getModel(final String modelId) throws Throwable {
        return mongoHttpClient.getModel(modelId);
    }

    @Override
    public ModelResponse updateModel(final ModelRequest modelRequest) throws Throwable {
        return mongoHttpClient.updateModel(modelRequest);
    }

    @Override
    public void deleteModel(final String modelId) throws Throwable {
        mongoHttpClient.deleteModel(modelId);
    }
}
