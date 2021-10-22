package avh.nuversity.digid.services.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import avh.nuversity.digid.model.AvhContact;
import avh.nuversity.digid.model.AvhIddocument;
import avh.nuversity.digid.model.AvhUser;
import avh.nuversity.digid.services.impl.query.ContactQuery;
import avh.nuversity.digid.services.impl.query.CreateTeacherQuery;
import avh.nuversity.digid.services.impl.query.CreateUserQuery;
import avh.nuversity.digid.services.impl.rep.AvhRep;
import avh.nuversity.digid.services.impl.response.CreateContactResponse;
import avh.nuversity.digid.services.impl.response.CreateContactStatus;
import avh.nuversity.digid.services.impl.response.CreateTeacherResponse;
import avh.nuversity.digid.services.impl.util.NumailNuidTeacher;
import enums.CitizenShip;
import enums.DomainType;
import enums.EmailStatus;
import enums.GroupType;
import enums.MaritalStatus;
import enums.PrimaryLanguage;

@Component
public class ContactControllerImpl {
	@Autowired
	private AvhRep rep;
	@Autowired
	private CommonFunction commonFunction;
	
	@Autowired
	private UserControllerImpl userImpl;
	 @Autowired
	    private FileStorageService fileStorageService;
	public AvhContact getContact(String id) {
		return rep.getContactRep().findByEmail(id);
	}
	
	
	public CreateContactResponse createContact(ContactQuery ctQuery) throws Exception {

		AvhContact usr = rep.getContactRep().findByEmail(ctQuery.getEmail());
		CreateContactResponse resp = new CreateContactResponse();
		if(usr != null) {
			resp.setEmail(ctQuery.getEmail());
			resp.setStatus(CreateContactStatus.EmailAlreadyExist);
			resp.setUserId(null);
			return resp;
		}
		
		
		AvhContact newContact = new AvhContact();
		newContact.setCaddress(ctQuery.getCaddress());
		if(ctQuery.getCitizenship() != "") {
			newContact.setCitizenship(ctQuery.getCitizenship());
		}else {
			newContact.setCitizenship(null);
		}
		
		newContact.setDob(ctQuery.getDob());
		newContact.setEmail(ctQuery.getEmail());
		newContact.setFirstname(ctQuery.getFirstname());
		newContact.setGender(ctQuery.getGender());
		
		if(ctQuery.getLandline() != "") {
			newContact.setLandline(ctQuery.getLandline());
		}else {
			newContact.setLandline(null);
		}
		
		
		newContact.setLastname(ctQuery.getLastname());
		if(ctQuery.getMaritalstatus() != "") {
			newContact.setMaritalstatus(ctQuery.getMaritalstatus());
		}else {
			newContact.setMaritalstatus(null);
		}
		
		
		newContact.setMiddlename(ctQuery.getMiddlename());
		newContact.setPhone(ctQuery.getPhone());
		newContact.setPrimarylanguage(ctQuery.getPrimarylanguage());
		newContact.setTitle(ctQuery.getTitle());
		
		
		if(ctQuery.getIddocument() != null && ctQuery.getIdimage() != null) {
			AvhIddocument iddoc = new AvhIddocument();
			iddoc.setCid(ctQuery.getIddocument());
			iddoc.setIdphoto(/*commonFunction.*/saveImage(ctQuery.getIdimage(),DigidConstants.IdPhotosPhotoPath));
			rep.getIDDRep().save(iddoc);
			newContact.setIddocumentBean(iddoc);
		}
		
		rep.getContactRep().save(newContact);
		CreateUserQuery userQuery = new CreateUserQuery();
		userQuery.setContactId(ctQuery.getEmail());
		userQuery.setDomain(DomainType.NUVERSITY.toString());
		userQuery.setGroup(GroupType.APPLICANT.toString());
		userQuery.setPassword("");
		String userId = userImpl.createUser(userQuery);
		
		int sendmail = this.commonFunction.sendPendingRequestAndEmail(DigidConstants.LinkSentSetPassword,ctQuery.getEmail(),DigidConstants.TimeToExpirySetPassMail,EmailStatus.SET_PASSWORD,DigidConstants.MailTitleSetPassword,userId,"M002");
		if(sendmail == 1) {
		resp.setEmail(ctQuery.getEmail());
		resp.setStatus(CreateContactStatus.Success);
		resp.setUserId(userId);
		return resp;
		}
		else {
			resp.setEmail(ctQuery.getEmail());
			resp.setStatus(CreateContactStatus.ErrorWhileSendingEmail);
			resp.setUserId(userId);
			return resp;
		}
	}

	public String updateContactInfos(ContactQuery ctQuery) throws IOException {
		
		AvhUser user = rep.getUserRep().findByUserid(ctQuery.getEmail());
		if(user == null) {
			return ErrorCode.UnknownUser;
		}
		
		AvhContact usr= user.getContact();
		if(usr == null) {
			return ErrorCode.UnknownUser;
		}
		
		if(ctQuery.getCaddress() != "") {
			usr.setCaddress(ctQuery.getCaddress());
		}else {
			usr.setCaddress(null);
		}
		
		
		if(ctQuery.getLandline() != "") {
			usr.setLandline(ctQuery.getLandline());
		}else {
			usr.setLandline(null);
		}
		
		if(ctQuery.getCitizenship() != "") {
			usr.setCitizenship(ctQuery.getCitizenship());
		}else {
			usr.setCitizenship(null);
		}
		
		if(ctQuery.getMaritalstatus() != "") {
			usr.setMaritalstatus(ctQuery.getMaritalstatus());
		}else {
			usr.setMaritalstatus(null);
		}
//		usr.setCitizenship(ctQuery.getCitizenship());
//		usr.setLandline(ctQuery.getLandline());
//		usr.setMaritalstatus(ctQuery.getMaritalstatus());
		usr.setPhone(ctQuery.getPhone());
		
		
		if(ctQuery.getIddocument() != null && ctQuery.getIdimage() != null) {
			AvhIddocument iddoc = new AvhIddocument();
			iddoc.setCid(ctQuery.getIddocument());
			iddoc.setIdphoto(/*commonFunction.*/saveImage(ctQuery.getIdimage(),DigidConstants.IdPhotosPhotoPath));
			rep.getIDDRep().save(iddoc);
			usr.setIddocumentBean(iddoc);
		}
		
		rep.getContactRep().save(usr);
		
		return "Success";
		
	}

//	public String newPhoto(String hello,MultipartFile photo,String dir) throws IOException {
//		String fileName = fileStorageService.storeFile(photo,dir);
//
//
//        return hello;
//	}
	
	public String saveImage(MultipartFile photo,String dir) throws IOException {

		String fileName = fileStorageService.storeFile(photo,dir);

        return dir+"/"+fileName;
	}


	public List<String> getMaritalStatus() {
		
	List<String> ls = new ArrayList<String>();
	ls.add(MaritalStatus.Married.toString());
	ls.add(MaritalStatus.Single.toString());
	return ls;
	}


	public List<String> getCitizenShip() {
	
		List<String> ls = new ArrayList<String>();
		ls.add(CitizenShip.AUSTRALIA.toString());
		ls.add(CitizenShip.LEBANON.toString());
		ls.add(CitizenShip.USA.toString());
		return ls;
	}


	public List<String> getPrimaryLanguage() {
		List<String> ls = new ArrayList<String>();
		ls.add(PrimaryLanguage.ARABIC.toString());
		ls.add(PrimaryLanguage.ENGLISH.toString());
		ls.add(PrimaryLanguage.FRENCH.toString());
		return ls;
	}


	public CreateTeacherResponse createTeacher(CreateTeacherQuery ctQuery) throws Exception {
		AvhContact usr = rep.getContactRep().findByEmail(ctQuery.getEmail());
		CreateTeacherResponse resp = new CreateTeacherResponse();
		if(usr != null) {
			resp.setEmail(ctQuery.getEmail());
			resp.setStatus(CreateContactStatus.EmailAlreadyExist);
			resp.setUserId(null);
			resp.setNumail(null);
			return resp;
		}
		
		
		AvhContact newContact = new AvhContact();
		newContact.setCaddress(ctQuery.getCaddress());
		newContact.setCitizenship(ctQuery.getCitizenship());
		newContact.setDob(ctQuery.getDob());
		newContact.setEmail(ctQuery.getEmail());
		newContact.setFirstname(ctQuery.getFirstname());
		newContact.setGender(ctQuery.getGender());
		newContact.setLandline(ctQuery.getLandline());
		newContact.setLastname(ctQuery.getLastname());
		newContact.setMaritalstatus(ctQuery.getMaritalstatus());
		newContact.setMiddlename(ctQuery.getMiddlename());
		newContact.setPhone(ctQuery.getPhone());
		newContact.setPrimarylanguage(ctQuery.getPrimarylanguage());
//     	String photoUrl = /*commonFunction.*/saveImage(ctQuery.getPhoto(),DigidConstants.ContactPhotoPath);
//		newContact.setPhoto(photoUrl);
		newContact.setTitle(ctQuery.getTitle());
		
		
		if(ctQuery.getIddocument() != null && ctQuery.getIdimage() != null) {
			AvhIddocument iddoc = new AvhIddocument();
			iddoc.setCid(ctQuery.getIddocument());
			iddoc.setIdphoto(/*commonFunction.*/saveImage(ctQuery.getIdimage(),DigidConstants.IdPhotosPhotoPath));
			rep.getIDDRep().save(iddoc);
			newContact.setIddocumentBean(iddoc);
		}
		
		rep.getContactRep().save(newContact);
		CreateUserQuery userQuery = new CreateUserQuery();
		userQuery.setContactId(ctQuery.getEmail());
		userQuery.setDomain(DomainType.NUVERSITY.toString());
		userQuery.setGroup(GroupType.TEACHER.toString());
		userQuery.setPassword(ctQuery.getPassword());
		NumailNuidTeacher userId = userImpl.createTeacher(userQuery);
		
		resp.setEmail(ctQuery.getEmail());
		resp.setStatus(CreateContactStatus.Success);
		resp.setUserId(userId.getNuid());
		resp.setNumail(userId.getNumail());
		return resp;
		
	}


	
}
