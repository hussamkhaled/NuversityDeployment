package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhFinancialAccount;

public interface FinancialAccountRep extends CrudRepository<AvhFinancialAccount, String>{

	public AvhFinancialAccount findByUserid(String userid);
}
