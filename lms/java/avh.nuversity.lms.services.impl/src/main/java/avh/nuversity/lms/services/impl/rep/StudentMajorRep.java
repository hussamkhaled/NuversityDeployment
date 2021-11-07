package avh.nuversity.lms.services.impl.rep;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import avh.nuversity.lms.model.AvhStudent;
import avh.nuversity.lms.model.AvhStudentMajor;

public interface StudentMajorRep extends CrudRepository<AvhStudentMajor, String>{

	public List<AvhStudentMajor> findByStudent(AvhStudent student);
}
