package phoenixit.education.httpClients.mongo;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.models.ModelResponse;

@RequiredArgsConstructor
@Service
public class MongoHttpClientImpl implements MongoHttpClient {

    private final JsonRpcHttpClient mongoClient;

    @Override
    public ModelResponse createModel(ModelRequest modelRequest) throws Throwable {
        return mongoClient.invoke("create", new Object[]{modelRequest}, ModelResponse.class);
    }

    @Override
    public ModelResponse getModel(String modelId) throws Throwable {
        return mongoClient.invoke("get", new Object[]{modelId}, ModelResponse.class);
    }

    @Override
    public ModelResponse updateModel(ModelRequest modelRequest) throws Throwable {
        return mongoClient.invoke("update", new Object[]{modelRequest}, ModelResponse.class);
    }

    @Override
    public void deleteModel(String modelId) throws Throwable {
        mongoClient.invoke("delete", new Object[]{modelId});
    }
}
