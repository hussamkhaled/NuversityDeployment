package avh.nuversity.digid.services.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;

import avh.nuversity.digid.model.AvhPendingRequest;
import avh.nuversity.digid.services.impl.rep.AvhRep;
import enums.EmailStatus;
import enums.PendingRequestStatus;

@Component
public class CommonFunction {

	@Autowired
	private AvhRep rep;
	
	@Autowired
	private MailService mailService;
	
//	private PendingRequestStatus prs;

	public CommonFunction(){}
	
	@Autowired
    private FileStorageService fileStorageService;
	
	public int sendPendingRequestAndEmail(String linksentforgetpassword, String usr,
			int timetoexpiryforgetpassmail, EmailStatus updatePassword, String mailtitleforgetpassword,String usrId,String msgid) throws Exception {
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString();
			AvhPendingRequest apr = new AvhPendingRequest();
			apr.setRlink(token);
			apr.setRstatus(PendingRequestStatus.PENDING.toString());
			LocalDateTime idate = LocalDateTime.now();
			apr.setIssuedate(idate);
			LocalDateTime edate = LocalDateTime.now().plusMinutes(timetoexpiryforgetpassmail);
			
			Calendar c = Calendar.getInstance();
			c.set(2030, 3, 23);
			TimeZone tz = c.getTimeZone();
			ZoneId zi = tz.toZoneId();
			LocalDateTime ldt = LocalDateTime.ofInstant(c.toInstant(), zi);
//			apr.setExpirydate(edate);
			apr.setExpirydate(ldt);
			apr.setRtype(updatePassword.toString());
			apr.setUsrid(usrId);
			rep.getPengingRep().save(apr);
			Properties prop = new Properties();
			if(updatePassword.equals(EmailStatus.UPDATE_PASSWORD)) {
			prop.setProperty("username", rep.getUserRep().findByUserid(usrId).getContact().getFirstname());
			prop.setProperty("link", linksentforgetpassword+"?token="+token+" ");
			}
			if(updatePassword.equals(EmailStatus.SET_PASSWORD)) {
				prop.setProperty("nuid", usrId);
				prop.setProperty("username", rep.getUserRep().findByUserid(usrId).getContact().getFirstname());
				prop.setProperty("link", linksentforgetpassword+"?token="+token+" ");
			}
			if(updatePassword.equals(EmailStatus.MAKE_STUDENT)) {
				prop.setProperty("numail", rep.getUserRep().findByUserid(usrId).getNumail());
				
				}
			this.mailService.sendMail(usr, msgid,prop);
			
			
		
		return 1;
	}
	
	public String saveImage(MultipartFile photo,String dir) throws IOException {

		String fileName = fileStorageService.storeFile(photo,dir);

        return dir+"/"+fileName;
	}

	
}
