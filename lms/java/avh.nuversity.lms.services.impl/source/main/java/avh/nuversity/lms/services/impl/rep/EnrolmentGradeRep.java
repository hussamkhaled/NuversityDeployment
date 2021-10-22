package avh.nuversity.lms.services.impl.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import avh.nuversity.lms.model.AvhEnrolmentGrade;
@Repository
public interface EnrolmentGradeRep extends CrudRepository<AvhEnrolmentGrade, String>{
	
	
}
