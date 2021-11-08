package avh.nuversity.lms.services.impl.rep;


import org.springframework.data.repository.CrudRepository;


import avh.nuversity.lms.model.AvhTeacher;

public interface TeacherRep extends CrudRepository<AvhTeacher, String>{
	public AvhTeacher findByIid(String iid);
}
