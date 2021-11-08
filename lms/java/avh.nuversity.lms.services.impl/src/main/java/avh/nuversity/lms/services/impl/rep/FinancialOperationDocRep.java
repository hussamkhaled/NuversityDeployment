package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.lms.model.AvhFinancialDocument;
import avh.nuversity.lms.model.AvhFinancialOperation;
@Repository
public interface FinancialOperationDocRep extends CrudRepository<AvhFinancialDocument, String>{


	public AvhFinancialDocument findByFinancialOperation(AvhFinancialOperation financialOperation);

}
