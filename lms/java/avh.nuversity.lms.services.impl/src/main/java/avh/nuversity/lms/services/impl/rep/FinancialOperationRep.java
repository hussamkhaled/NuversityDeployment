package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhFinancialAccount;
import avh.nuversity.lms.model.AvhFinancialOperation;

public interface FinancialOperationRep extends CrudRepository<AvhFinancialOperation, String>{
	
public List<AvhFinancialOperation> findByFinancialAccount(AvhFinancialAccount financialAccount);


}
