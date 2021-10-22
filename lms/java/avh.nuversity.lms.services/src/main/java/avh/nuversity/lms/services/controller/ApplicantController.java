package avh.nuversity.lms.services.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import avh.nuversity.lms.model.AvhApplication;

import avh.nuversity.lms.services.impl.ApplicantControllerImpl;
import avh.nuversity.lms.services.impl.query.CreateApplicantQuery;
import avh.nuversity.lms.services.impl.response.ApplicationAndApplicantResponse;
import avh.nuversity.lms.services.impl.response.CreateApplicantResponse;

@RestController
public class ApplicantController {

	@Autowired
	private ApplicantControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/applicatntwithapplication")
	public CreateApplicantResponse newApplicatnt(@RequestBody CreateApplicantQuery fc) {
		return svc.createApplicant(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/addApplicationDocument")
	public String applicationDocument(@RequestParam("docs") MultipartFile[] docs,@RequestParam("application") String application,@RequestParam("docName") String[] docName) throws IOException {
		return svc.applicationDocument(docs,application,docName);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/application/{id}")
	public AvhApplication getApplication(@PathVariable("id") String cttId) {
		return svc.getApplication(cttId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/applicationByUserId/{id}")
	public AvhApplication getApplicationByUserId(@PathVariable("id") String cttId) {
		return svc.getApplicationByUserId(cttId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/applicationAndApplicantByUserId/{id}")
	public ApplicationAndApplicantResponse getApplicationAndApplicantByUserId(@PathVariable("id") String cttId) {
		return svc.getApplicationAndApplicantByUserId(cttId);
	}
	
}
