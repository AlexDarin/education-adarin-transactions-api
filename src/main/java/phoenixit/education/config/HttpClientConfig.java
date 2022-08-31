package phoenixit.education.config;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class HttpClientConfig {

    @Value("${rpc.clients.mongoApi}")
    private String mongoClient;

    @Value("${rpc.clients.neo4jModelApi}")
    private String neo4jModelClient;

    @Value("${rpc.clients.neo4jClassApi}")
    private String neo4jClassClient;

    @Bean("mongoClient")
    public JsonRpcHttpClient getMongoClient() throws MalformedURLException {
        return new JsonRpcHttpClient(new URL(mongoClient));
    }

    @Bean("neo4jModelClient")
    public JsonRpcHttpClient getNeo4jModelClient() throws MalformedURLException {
        return new JsonRpcHttpClient(new URL(neo4jModelClient));
    }

    @Bean("neo4jClassClient")
    public JsonRpcHttpClient getNeo4jClassClient() throws MalformedURLException {
        return new JsonRpcHttpClient(new URL(neo4jClassClient));
    }
}
