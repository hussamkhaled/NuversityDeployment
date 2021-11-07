package avh.nuversity.digid.services.controller;

import java.io.IOException;


import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import avh.nuversity.digid.model.AvhContact;
import avh.nuversity.digid.services.impl.ContactControllerImpl;
import avh.nuversity.digid.services.impl.query.ContactQuery;
import avh.nuversity.digid.services.impl.query.CreateTeacherQuery;
import avh.nuversity.digid.services.impl.response.CreateContactResponse;
import avh.nuversity.digid.services.impl.response.CreateTeacherResponse;


@RestController
public class ContactController {
	@Autowired
	private ContactControllerImpl svc;
	
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/contact/{id}")
	public AvhContact getContact(@PathVariable("id") String cttId) {
		return svc.getContact(cttId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/contact")
	public CreateContactResponse newContact(
						     @RequestParam("gender") String gender,
							 @RequestParam("email") String email,
							 @RequestParam("caddress") String caddress,
							 @RequestParam("citizenship") String citizenship,
							 @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dob,
							 @RequestParam("firstname") String firstname,
							 @RequestParam("landline") String landline,
							 @RequestParam("lastname") String lastname,
							 @RequestParam("maritalstatus") String maritalstatus,
							 @RequestParam("middlename") String middlename,
							 @RequestParam("phone") String phone,
							 @RequestParam("primarylanguage") String primarylanguage,
							 @RequestParam("passportnumber") String iddocument,
							 @RequestParam("passportfile") MultipartFile idimage
							 ) throws Exception {
		
		ContactQuery ctt = new ContactQuery();
		ctt.setCaddress(caddress);
		ctt.setCitizenship(citizenship);
		ctt.setEmail(email);
		ctt.setFirstname(firstname);
		ctt.setGender(gender);
		ctt.setIddocument(iddocument);
		ctt.setIdimage(idimage);
		ctt.setLandline(landline);
		ctt.setLastname(lastname);
		ctt.setMaritalstatus(maritalstatus);
		ctt.setMiddlename(middlename);
		ctt.setPhone(phone);
		ctt.setPrimarylanguage(primarylanguage);
		ctt.setTitle("Mr");
		ctt.setDob(dob);


		return svc.createContact(ctt);
		
	}
	

	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PutMapping("/nuversity/api/digid/updateContact")
	public String updateContactInfos(@RequestParam("userid") String userId,
									 @RequestParam("caddress") String caddress,
									 @RequestParam("citizenship") String citizenship,
									 @RequestParam("landline") String landline,
									 @RequestParam("maritalstatus") String maritalstatus,
									 @RequestParam("phone") String phone,
									 @RequestParam(value="passportnumber",required=false) String iddocument,
									 @RequestParam(value="passportfile",required=false) MultipartFile idimage
									 ) throws IOException {

		ContactQuery ctt = new ContactQuery();

			ctt.setCaddress(caddress);
			ctt.setCitizenship(citizenship);
			if(iddocument == null && idimage == null) {
				ctt.setIddocument(null);
				ctt.setIdimage(null);
			}else {
				ctt.setIddocument(iddocument);
				ctt.setIdimage(idimage);
			}
			
			ctt.setLandline(landline);
			ctt.setMaritalstatus(maritalstatus);
			ctt.setPhone(phone);
			ctt.setEmail(userId);
			return svc.updateContactInfos(ctt);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/getMaritalStatus")
	public List<String> getMaritalStatus() {
		return svc.getMaritalStatus();
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/getCitizenShip")
	public List<String> getCitizenShip() {
		return svc.getCitizenShip();
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/getPrimaryLanguage")
	public List<String> getPrimaryLanguage() {
		return svc.getPrimaryLanguage();
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/teacher")
	public CreateTeacherResponse newTeacher(
						     @RequestParam("gender") String gender,
							 @RequestParam("email") String email,
							 @RequestParam("caddress") String caddress,
							 @RequestParam("citizenship") String citizenship,
							 @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dob,
							 @RequestParam("firstname") String firstname,
							 @RequestParam("landline") String landline,
							 @RequestParam("lastname") String lastname,
							 @RequestParam("maritalstatus") String maritalstatus,
							 @RequestParam("middlename") String middlename,
							 @RequestParam("phone") String phone,
							 @RequestParam("primarylanguage") String primarylanguage,
							 @RequestParam("passportnumber") String iddocument,
							 @RequestParam("passportfile") MultipartFile idimage,
							 @RequestParam("password") String password
							 ) throws Exception {
		
		CreateTeacherQuery ctt = new CreateTeacherQuery();
		ctt.setCaddress(caddress);
		ctt.setCitizenship(citizenship);
		ctt.setEmail(email);
		ctt.setFirstname(firstname);
		ctt.setGender(gender);
		ctt.setIddocument(iddocument);
		ctt.setIdimage(idimage);
		ctt.setLandline(landline);
		ctt.setLastname(lastname);
		ctt.setMaritalstatus(maritalstatus);
		ctt.setMiddlename(middlename);
		ctt.setPhone(phone);
		ctt.setPrimarylanguage(primarylanguage);
		ctt.setTitle("Mr");
		ctt.setDob(dob);
		ctt.setPassword(password);


		return svc.createTeacher(ctt);
		
	}
}
