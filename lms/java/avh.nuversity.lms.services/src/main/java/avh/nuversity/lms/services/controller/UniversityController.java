package avh.nuversity.lms.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.services.impl.UniversityControllerImpl;

@RestController
public class UniversityController {

	@Autowired
	private UniversityControllerImpl svc;
}
