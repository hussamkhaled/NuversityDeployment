package avh.nuversity.lms.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.lms.model.AvhContractSheet;
import avh.nuversity.lms.model.AvhMajor;
import avh.nuversity.lms.services.impl.MajorControllerImpl;
import avh.nuversity.lms.services.impl.query.ContractSheetQuery;

import avh.nuversity.lms.services.impl.query.CreateMajorQuery;
import avh.nuversity.lms.services.impl.query.MajorCourseQuery;
import avh.nuversity.lms.services.impl.response.MajorByProgramResponse;
import avh.nuversity.lms.services.impl.response.MajorContractSheetResponse;
import avh.nuversity.lms.services.impl.response.MajorDescPreResponse;
import avh.nuversity.lms.services.impl.response.MajorReqDocResponse;

@RestController
public class MajorController {

	@Autowired
	private MajorControllerImpl svc;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/major")
	public AvhMajor newMajor(@RequestBody CreateMajorQuery fc) {
		return svc.createMajor(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/majorCourse")
	public String addCourse(@RequestBody MajorCourseQuery fc) {
		return svc.majorCourse(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/lms/contractSheet")
	public String contractSheet(@RequestBody ContractSheetQuery fc) {
		return svc.contractSheet(fc);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/major/{id}")
	public String getMajorById(@PathVariable("id") String MId) {
		return svc.getMajorById(MId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getMajorsByProgramsAndCerificate/{pgmid}/{cer}")
	public List<MajorByProgramResponse> getMajorsByProgramsAndCerificate(@PathVariable("pgmid") String pId,@PathVariable("cer") String cer) {
		return svc.getMajorsByProgramsAndCerificate(pId,cer);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/getMajorDescriptionAndPre/{majorid}")
	public MajorDescPreResponse getMajorDescAndPre(@PathVariable("majorid") String mId) {
		return svc.getMajorDescAndPre(mId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/majorById/{id}")
	public AvhMajor getAllMajorAttById(@PathVariable("id") String MId) {
		return svc.getAllMajorAttById(MId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/majorContractSheet/{id}")
	public MajorContractSheetResponse getmajorContractSheet(@PathVariable("id") String MId) {
		return svc.getmajorContractSheet(MId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/lms/majorRequiredDoc/{id}")
	public List<MajorReqDocResponse> getmajorRequiredDoc(@PathVariable("id") String MId) {
		return svc.getmajorRequiredDoc(MId);
	}
	
}
