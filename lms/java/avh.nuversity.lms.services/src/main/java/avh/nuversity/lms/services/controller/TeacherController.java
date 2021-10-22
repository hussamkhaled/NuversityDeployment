package avh.nuversity.lms.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import avh.nuversity.lms.model.AvhTeacher;
import avh.nuversity.lms.services.impl.TeacherControllerImpl;

@RestController
public class TeacherController {

	@Autowired
	private TeacherControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/teacher")
	public AvhTeacher newTeacher(@RequestBody AvhTeacher fc) {
		return svc.createTeacher(fc);
	}
}
