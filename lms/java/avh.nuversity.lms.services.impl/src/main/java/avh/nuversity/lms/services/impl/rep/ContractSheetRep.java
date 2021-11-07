package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhContractSheet;
import avh.nuversity.lms.model.AvhMajor;

public interface ContractSheetRep extends CrudRepository<AvhContractSheet, String>{

	public AvhContractSheet findByMajorBean(AvhMajor majorBean);
}
