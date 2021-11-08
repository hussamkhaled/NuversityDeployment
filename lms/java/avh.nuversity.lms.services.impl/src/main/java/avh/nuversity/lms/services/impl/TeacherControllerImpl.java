package avh.nuversity.lms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import avh.nuversity.lms.model.AvhTeacher;
import avh.nuversity.lms.services.impl.rep.AvhRep;

@Component
public class TeacherControllerImpl {
	@Autowired
	private AvhRep rep;

	public AvhTeacher createTeacher(AvhTeacher fc) {
		
		fc.setIid(fc.getUserid());
		rep.getTeacherRep().save(fc);
		return fc;
	}
}
