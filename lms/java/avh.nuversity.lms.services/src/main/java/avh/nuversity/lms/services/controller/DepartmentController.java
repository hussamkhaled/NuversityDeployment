package avh.nuversity.lms.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.model.AvhDepartment;

import avh.nuversity.lms.services.impl.DepartmentControllerImpl;
import avh.nuversity.lms.services.impl.query.CreateDepartmentQuery;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/department")
	public AvhDepartment newDepartment(@RequestBody CreateDepartmentQuery fc) {
		return svc.createDepartment(fc);
	}
}
