package phoenixit.education.jsonPRC;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import phoenixit.education.models.ModelCard;
import phoenixit.education.models.ModelRequest;
import phoenixit.education.services.TransactionService;

@AutoJsonRpcServiceImpl
@Service
@RequiredArgsConstructor
public class TransactionRPCImpl implements TransactionRPC {

    private final TransactionService transactionService;

    @Override
    public ModelCard create(ModelRequest modelRequest, Long classNodeId) throws Throwable {
        return transactionService.create(modelRequest, classNodeId);
    }

    @Override
    public ModelCard update(ModelRequest modelRequest) throws Throwable {
        return transactionService.update(modelRequest);
    }

    @Override
    public void deleteById(String id) throws Throwable {
        transactionService.deleteById(id);
    }

    @Override
    public ModelCard fetchById(String id) throws Throwable {
        return transactionService.fetchById(id);
    }
}
