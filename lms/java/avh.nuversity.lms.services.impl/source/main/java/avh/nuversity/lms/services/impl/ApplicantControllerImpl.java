package avh.nuversity.lms.services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import avh.nuversity.lms.model.AvhAppDoc;
import avh.nuversity.lms.model.AvhApplicant;
import avh.nuversity.lms.model.AvhApplication;
import avh.nuversity.lms.model.AvhStudentMajor;
import avh.nuversity.lms.services.impl.query.CreateApplicantQuery;
import avh.nuversity.lms.services.impl.rep.AvhRep;
import avh.nuversity.lms.services.impl.response.ApplicationAndApplicantResponse;
import avh.nuversity.lms.services.impl.response.CreateApplicantResponse;
import enums.ApplicationStatus;

@Component
public class ApplicantControllerImpl {

	@Autowired
	private AvhRep rep;
	@Autowired
	FileStorageService fileStorageService;

	public CreateApplicantResponse createApplicant(CreateApplicantQuery fc) {
		AvhApplicant applicant = new AvhApplicant();
		AvhApplication application = new AvhApplication();
		
		CreateApplicantResponse resp = new CreateApplicantResponse();
		applicant.setIid(fc.getUserid());
		applicant.setUserid(fc.getUserid());
		rep.getApplicantRep().save(applicant);
		
		application.setAppdate(LocalDate.now());
		application.setApplicantBean(applicant);
		application.setIid(UUID.randomUUID().toString());
		application.setMajorBean(rep.getMajorRep().findByIid(fc.getMajor()));
		application.setStatus(ApplicationStatus.PENDING.toString());
		rep.getApplicationRep().save(application);
		
		resp.setApplicant(applicant.getIid());
		resp.setApplication(application.getIid());
		resp.setUserid(fc.getUserid());
		
		return resp;
		
	}

	public String applicationDocument(MultipartFile[] docs, String application ,String[] docName) throws IOException {
		
		
		
		int n = 0;
		for (MultipartFile appDoc : docs) {
			
			AvhAppDoc apd = new AvhAppDoc();
			apd.setApplication(rep.getApplicationRep().findByIid(application));
			apd.setDlabel(docName[n]);//docName.get(n));
			apd.setDocPath(saveImage(appDoc, "photos/applicationDocument"));
			apd.setIid(UUID.randomUUID().toString());
			rep.getAppDocrep().save(apd);
			n++;
		}
		
		return "Success";
	}
	
	public String saveImage(MultipartFile photo,String dir) throws IOException {

		String fileName = fileStorageService.storeFile(photo,dir);

        return dir+"/"+fileName;
	}

	public AvhApplication getApplication(String cttId) {
		return rep.getApplicationRep().findByIid(cttId);
	}

	public AvhApplication getApplicationByUserId(String cttId) {
		
		return rep.getApplicationRep().findByApplicantBean(rep.getApplicantRep().findByIid(cttId));
	}

	public ApplicationAndApplicantResponse getApplicationAndApplicantByUserId(String cttId) {
		ApplicationAndApplicantResponse res = new ApplicationAndApplicantResponse();
		
		AvhApplicant applicant = rep.getApplicantRep().findByUserid(cttId);
		if(applicant != null) {
			res.setApplicant(applicant.getUserid());
		}else {
			res.setApplicant("nan");
		}
		AvhApplication application = rep.getApplicationRep().findByApplicantBean(rep.getApplicantRep().findByUserid(cttId));
		if(application != null) {
			res.setApplication(application.getIid());
			}else {
				res.setApplication(null);
			}
		
		List<AvhStudentMajor> sm = rep.getStdMajorRep().findByStudent(rep.getStudentRep().findByUserid(cttId));
		if(sm.size() != 0) {
			List<String> majorsList = new ArrayList<String>();
			for (AvhStudentMajor avhStudentMajor : sm) {
				majorsList.add(avhStudentMajor.getMajorid());
			}
			res.setMajors(majorsList);
		}else {
			res.setMajors(null);
		}
		
		return res;
	}
	
}
