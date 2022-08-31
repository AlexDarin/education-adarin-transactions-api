package phoenixit.education.services;

import phoenixit.education.models.ModelCard;
import phoenixit.education.models.ModelRequest;

public interface TransactionService {

    ModelCard create(ModelRequest modelRequest, Long classNodeId) throws Throwable;

    ModelCard update(ModelRequest modelRequest) throws Throwable;

    void deleteById(String id) throws Throwable;

    ModelCard fetchById(String id) throws Throwable;
}
