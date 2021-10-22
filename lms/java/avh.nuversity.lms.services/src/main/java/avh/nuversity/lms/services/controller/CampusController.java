package avh.nuversity.lms.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import avh.nuversity.lms.model.AvhCampus;
import avh.nuversity.lms.services.impl.CampusControllerImpl;

@RestController
public class CampusController {

	@Autowired
	private CampusControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/campus")
	public AvhCampus newCampus(@RequestBody AvhCampus cmp) {
		return svc.createCampus(cmp);
	}
}
