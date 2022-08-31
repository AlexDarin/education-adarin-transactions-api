package phoenixit.education.jsonPRC;

import com.googlecode.jsonrpc4j.JsonRpcError;
import com.googlecode.jsonrpc4j.JsonRpcErrors;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import phoenixit.education.models.ModelCard;
import phoenixit.education.models.ModelRequest;

import javax.persistence.EntityNotFoundException;

@JsonRpcService("/transaction")
public interface TransactionRPC {

    ModelCard create(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest, @JsonRpcParam(value = "classNodeId") Long classNodeId) throws Throwable;

    @JsonRpcErrors({
            @JsonRpcError(exception = EntityNotFoundException.class, code = 404),
            @JsonRpcError(exception = IllegalArgumentException.class, code = 500)
    })
    ModelCard update(@JsonRpcParam(value = "modelRequest") ModelRequest modelRequest) throws Throwable;

    @JsonRpcErrors({
            @JsonRpcError(exception = EntityNotFoundException.class, code = 404)
    })
    void deleteById(@JsonRpcParam(value = "id") String id) throws Throwable;

    @JsonRpcErrors({
            @JsonRpcError(exception = EntityNotFoundException.class, code = 404)
    })
    ModelCard fetchById(@JsonRpcParam(value = "id") String id) throws Throwable;
}
