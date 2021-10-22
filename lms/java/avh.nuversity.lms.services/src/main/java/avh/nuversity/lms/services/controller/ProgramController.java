package avh.nuversity.lms.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.model.AvhPgm;
import avh.nuversity.lms.services.impl.ProgramControllerImpl;

import avh.nuversity.lms.services.impl.query.CreateProgramQuery;
import avh.nuversity.lms.services.impl.response.AllProgramsResponse;

@RestController
public class ProgramController {

	@Autowired
	private ProgramControllerImpl svc;
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/program")
	public AvhPgm newProgram(@RequestBody CreateProgramQuery fc) {
		return svc.createProgram(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/getAllPrograms")
	public List<AllProgramsResponse> getAllPrograms() {
		return svc.getAllPrograms();
	}
}
