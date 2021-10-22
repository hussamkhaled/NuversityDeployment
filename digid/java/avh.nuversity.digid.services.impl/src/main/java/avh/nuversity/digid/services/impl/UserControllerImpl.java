package avh.nuversity.digid.services.impl;


import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import avh.nuversity.digid.model.AvhContact;
import avh.nuversity.digid.model.AvhCredentials;
import avh.nuversity.digid.model.AvhGroup;
import avh.nuversity.digid.model.AvhNuidsequesncenumber;
import avh.nuversity.digid.model.AvhPendingRequest;
import avh.nuversity.digid.model.AvhUser;
import avh.nuversity.digid.model.AvhUsergroup;
import enums.DomainType;
import enums.EmailStatus;
import enums.GroupType;
import enums.MethodType;
import avh.nuversity.digid.services.impl.query.ChangeForgottenPasswordQuery;
import avh.nuversity.digid.services.impl.query.CreateUserQuery;
import avh.nuversity.digid.services.impl.query.ForgetPasswordQuery;
import avh.nuversity.digid.services.impl.query.ResetPasswordQuery;
import avh.nuversity.digid.services.impl.query.SetPasswordQuery;
import avh.nuversity.digid.services.impl.rep.AvhRep;
import avh.nuversity.digid.services.impl.response.AuthenticateResponse;
import avh.nuversity.digid.services.impl.response.LoginStatus;
import avh.nuversity.digid.services.impl.response.MakeStudentResponse;
import avh.nuversity.digid.services.impl.response.PendingRequestResponse;
import avh.nuversity.digid.services.impl.response.PendingRequestStatus;
import avh.nuversity.digid.services.impl.response.ResetPasswordResponse;
import avh.nuversity.digid.services.impl.response.ResetPasswordStatus;
import avh.nuversity.digid.services.impl.util.NumailNuidTeacher;
import avh.nuversity.digid.services.impl.util.PasswordHasher;

@Component
public class UserControllerImpl {
	@Autowired
	private AvhRep rep;
	
	@Autowired 
	private PasswordHasher pHasher;
	
	@Autowired
	private CommonFunction CommonFunction;

	
	public AvhUser getUser(String id) {
		return rep.getUserRep().findByUserid(id);
	}
	
	@Transactional
	public String createUser(CreateUserQuery usrQuery) {
		AvhContact ctt = rep.getContactRep().findByEmail(usrQuery.getContactId());
		AvhGroup grp = rep.getGroupRep().findById(usrQuery.getGroup()).get();
		String uid = generateUserId(ctt,usrQuery,grp);

		
		
		AvhUser usr = new AvhUser();
		usr.setContact(ctt);
		usr.setDomainid(usrQuery.getDomain());
		usr.setJoiningDate(new Timestamp(System.currentTimeMillis()));
		usr.setNumail(null);
		usr.setUserid(uid);
		usr.setAcredential(null);
		rep.getUserRep().save(usr);
		
		AvhUsergroup ugrp = new AvhUsergroup();
		ugrp.setAuser(usr);
		ugrp.setEgroup(grp);
		ugrp.setEid(UUID.randomUUID().toString());
		rep.getUGRep().save(ugrp);
		
		return uid;
	}
	
	@Transactional
	public NumailNuidTeacher createTeacher(CreateUserQuery usrQuery) {
		NumailNuidTeacher resp = new NumailNuidTeacher();
		AvhContact ctt = rep.getContactRep().findByEmail(usrQuery.getContactId());
		AvhGroup grp = rep.getGroupRep().findById(usrQuery.getGroup()).get();
		String uid = generateUserId(ctt,usrQuery,grp);

		
		
		AvhUser usr = new AvhUser();
		usr.setContact(ctt);
		usr.setDomainid(usrQuery.getDomain());
		usr.setJoiningDate(new Timestamp(System.currentTimeMillis()));
		usr.setNumail(this.generateNumail(ctt));
		usr.setUserid(uid);
		AvhCredentials cred = new AvhCredentials();
		cred.setCredId(UUID.randomUUID().toString());
		cred.setBlocked(false);
		cred.setCmethod(MethodType.Password.toString());
		cred.setCredId(UUID.randomUUID().toString());
		cred.setExpireBy(LocalDate.now().plusMonths(DigidConstants.timetoexpirypassword));
		cred.setLoginid("True");
		cred.setPwddata(pHasher.hashPassword(usrQuery.getPassword()));
		cred.setTryCount(0);
		rep.getCredentialRep().save(cred);
		
		usr.setAcredential(cred);
		rep.getUserRep().save(usr);
		
		AvhUsergroup ugrp = new AvhUsergroup();
		ugrp.setAuser(usr);
		ugrp.setEgroup(grp);
		ugrp.setEid(UUID.randomUUID().toString());
		rep.getUGRep().save(ugrp);
		
	
		resp.setNuid(uid);
		resp.setNumail(usr.getNumail());
		return resp;
	}
	
	public AuthenticateResponse authenticateUser(String email, String password) {
//		AvhCredentials crd = rep.getCredentialRep().findByLoginidAndCmethod(email, MethodType.Password.toString());
//		AvhContact cct = rep.getContactRep().findByEmail(email);
		AvhUser usr = rep.getUserRep().findByNumail(email);
		
			if(usr == null) {
				usr = rep.getUserRep().findByUserid(email);
				}
		AuthenticateResponse res = new AuthenticateResponse();
		
		if (usr == null) {
			res.setEmail(email);
			res.setStatus(LoginStatus.UnregisteredEmail);
			res.setGroup(null);
			res.setUserId(null);
			return res;
		}
		
		AvhCredentials crd = usr.getAcredential();
		
		if (crd == null) {
			res.setEmail(email);
			res.setStatus(LoginStatus.UnregisteredEmail);
			res.setGroup(null);
			res.setUserId(null);
			return res;
		}
		
		res.setEmail(email);
		res.setUserId(usr.getUserid());
		AvhUsergroup ugr =rep.getUGRep().findByAuser(usr);
		String grptype = ugr.getEgroup().getGlabel();
		res.setGroup(grptype);
		res.setName(usr.getContact().getFirstname() +" "+ usr.getContact().getLastname());
		
		if (crd.getBlocked()) {
			res.setStatus(LoginStatus.BlockedAccount);
			return res;
		}
		
		boolean match = pHasher.match(password, crd.getPwddata());
		if (!match) {
			int tCount = crd.getTryCount() + 1;
			crd.setTryCount(tCount);
			if (tCount > DigidConstants.MAX_TRY) {
				blockCredentials(crd);
				res.setStatus(LoginStatus.BlockedAccount);
			} else {
				res.setStatus(LoginStatus.WrongPassword);
				rep.getCredentialRep().save(crd);
			}
		} else { // password match
			if (LocalDate.now().compareTo(crd.getExpireBy()) >= 0)
				res.setStatus(LoginStatus.ExpiredPassword);
			else
				crd.setTryCount(0);
				rep.getCredentialRep().save(crd);
				res.setStatus(LoginStatus.Success);
		}
		return res;
	}

	private void blockCredentials(AvhCredentials crd) {
		crd.setBlocked(true);
		rep.getCredentialRep().save(crd);
	}
	
	private String generateUserId(AvhContact ctt ,CreateUserQuery usr, AvhGroup grp) {
		String id = "";
		Date date = new Date();
		@SuppressWarnings("deprecation")
		int year = date.getYear();
		int currentYear = year + 1900;
		int yearInId = currentYear%100;
		id +=yearInId;
		String domain = usr.getDomain();
		if (domain.equals(DomainType.NUVERSITY.toString())) {
			id+="01";
		}else {
			id+="02";
		}
		String groupe = grp.getGlabel();
		if(groupe.equals(GroupType.ADMIN.toString())) {
			id+=DigidConstants.AdminNumail;
			String seqN = getSequenceNumber(groupe,yearInId);
			id+=seqN;
		}else if(groupe.equals(GroupType.TEACHER.toString())){
			id+=DigidConstants.TeacherNumail;
			String seqN = getSequenceNumber(groupe,yearInId);
			id+=seqN;
		}else if(groupe.equals(GroupType.STUDENT.toString()) || groupe.equals(GroupType.APPLICANT.toString())) {
			id+=DigidConstants.StudentNumail;
			String seqN = getSequenceNumber(GroupType.STUDENT.toString(),yearInId);
			id+=seqN;
		}else if(groupe.equals("OTHER")){
			id+=DigidConstants.OtherNumail;
			String seqN = getSequenceNumber(groupe,yearInId);
			id+=seqN;
		}
		return id;
	}
	
	private String getSequenceNumber(String groupe,int year) {
		String number="";
		AvhNuidsequesncenumber seqNum = rep.getNSNRep().findByGroupe(groupe);
			int seq = Integer.parseInt(seqNum.getSquence());
			if(seq == 9999) {
				number = "0001";
				number = String.format("%04d", seq);
				seqNum.setSquence(number);
				rep.getNSNRep().save(seqNum);
				return number;
			}else {
				seq++;	
				number = String.format("%04d", seq);
				seqNum.setSquence(number);
				rep.getNSNRep().save(seqNum);
				return number;
			}	
	
		
	}

	
	
	
	public String postEmailforgetPassword(ForgetPasswordQuery usr) throws Exception {
		AvhUser user = rep.getUserRep().findByNumail(usr.getEmail());
		if(user == null) {
			AvhContact ct = rep.getContactRep().findByEmail(usr.getEmail());
			user = rep.getUserRep().findByContact(ct);
			if(ct == null) {
			return ErrorCode.UnknownUser;
			}
		}
		int test = this.CommonFunction.sendPendingRequestAndEmail(DigidConstants.LinkSentForgetPassword,usr.getEmail(),DigidConstants.TimeToExpiryForgetPassMail,EmailStatus.UPDATE_PASSWORD,DigidConstants.MailTitleForgetPassword,user.getUserid(),"M001");
	
			if(test == 1) {
				return ErrorCode.Success;
			}
		return ErrorCode.SomthingWrong;
	
	}

	public PendingRequestResponse changeforgettenPassword(ChangeForgottenPasswordQuery usr) {
		
		
		AvhPendingRequest pendingRequest = rep.getPengingRep().findByRlink(usr.getToken());
		PendingRequestResponse rsp = new PendingRequestResponse();
		if(pendingRequest == null) {
			rsp.setStatus(PendingRequestStatus.LinkNotExist);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		LocalDateTime edate = LocalDateTime.now();
		if(edate.compareTo(pendingRequest.getExpirydate())>0 || pendingRequest.getRstatus().equals(DigidConstants.EXPIRED) || pendingRequest.getRstatus().equals(DigidConstants.CONFIRMED)) {
			rsp.setStatus(PendingRequestStatus.LinkExpired);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		if(! pendingRequest.getUsrid().equals(usr.getEmail())) {
			rsp.setStatus(PendingRequestStatus.UnknownUser);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		if(! usr.getPassword().equals(usr.getConfirmPassword())) {
			rsp.setStatus(PendingRequestStatus.PasswordNotSame);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		AvhUser user = rep.getUserRep().findByUserid(usr.getEmail());
		AvhCredentials cred = user.getAcredential();
		cred.setPwddata(pHasher.hashPassword(usr.getPassword()));
		cred.setExpireBy(LocalDate.now().plusMonths(DigidConstants.timetoexpirypassword));
		cred.setTryCount(DigidConstants.MAX_TRY);
		rep.getCredentialRep().save(cred);
		pendingRequest.setRstatus(DigidConstants.CONFIRMED);
		rep.getPengingRep().save(pendingRequest);
		rsp.setStatus(PendingRequestStatus.Success);
		rsp.setEmail(usr.getEmail());
		return rsp;
	}

	public ResetPasswordResponse resetPassword(ResetPasswordQuery usr) {
		
		
		AvhUser user = rep.getUserRep().findByUserid(usr.getEmail());
		if(user == null) {
			user = rep.getUserRep().findByNumail(usr.getEmail());
		}
		ResetPasswordResponse rsp = new ResetPasswordResponse();
		
		if(user == null) {
			rsp.setStatus(ResetPasswordStatus.UnknownUser);
			rsp.setUserid(null);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		AvhCredentials cred = user.getAcredential();
		
		if (! pHasher.match(usr.getOldPassword(), cred.getPwddata())) {
			rsp.setStatus(ResetPasswordStatus.OldPasswordWrong);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		if(! usr.getPassword().equals(usr.getConfirmPassword())) {
			rsp.setStatus(ResetPasswordStatus.PasswordNotSame);
			rsp.setEmail(usr.getEmail());
			return rsp;
		}
		
		cred.setPwddata(pHasher.hashPassword(usr.getPassword()));
		cred.setExpireBy(LocalDate.now().plusMonths(DigidConstants.timetoexpirypassword));
		cred.setTryCount(DigidConstants.MAX_TRY);
		rep.getCredentialRep().save(cred);
		
		rsp.setStatus(ResetPasswordStatus.Success);
		rsp.setUserid(user.getUserid());
		rsp.setEmail(usr.getEmail());
		return rsp;
	}

	public AvhUser getUserByToken(String usrId) {
		AvhPendingRequest prq = rep.getPengingRep().findByRlink(usrId);
		AvhUser user =rep.getUserRep().findByUserid(prq.getUsrid()); 
		return user;
	}

	public String setPassword(SetPasswordQuery usr) {
		AvhPendingRequest prq = rep.getPengingRep().findByRlink(usr.getToken());
		AvhUser ur = rep.getUserRep().findByUserid(usr.getUserId());
		if(prq == null) {
			return ErrorCode.UnknownLink;
		}
		if(! prq.getUsrid().equals(usr.getUserId())) {
			return ErrorCode.UnknownUser;
		}
		
		LocalDateTime edate = LocalDateTime.now();
		if(edate.compareTo(prq.getExpirydate())>0 || prq.getRstatus().equals(enums.PendingRequestStatus.EXPIRED.toString()) || prq.getRstatus().equals(enums.PendingRequestStatus.CONFIRMED.toString())) {
			prq.setRstatus(enums.PendingRequestStatus.EXPIRED.toString());
			rep.getPengingRep().save(prq);
			return ErrorCode.linkExpired;		
		}
		
		if(! usr.getPassword().equals(usr.getConfirmPassword())) {
			return ErrorCode.passwordNotSame;
		}
		
		AvhCredentials cred = new AvhCredentials();
		cred.setCredId(UUID.randomUUID().toString());
		cred.setBlocked(false);
		cred.setCmethod(MethodType.Password.toString());
		cred.setCredId(UUID.randomUUID().toString());
		cred.setExpireBy(LocalDate.now().plusMonths(DigidConstants.timetoexpirypassword));
		cred.setLoginid("True");
		cred.setPwddata(pHasher.hashPassword(usr.getPassword()));
		cred.setTryCount(0);
		rep.getCredentialRep().save(cred);
		
		ur.setAcredential(cred);
		rep.getUserRep().save(ur);
		
		prq.setRstatus(enums.PendingRequestStatus.CONFIRMED.toString());
		rep.getPengingRep().save(prq);
		return ErrorCode.Success;
	}

	public MakeStudentResponse makeStudent(String userid) throws Exception {
		MakeStudentResponse resp = new MakeStudentResponse();
		AvhUser usr = rep.getUserRep().findByUserid(userid);
		usr.setNumail(this.generateNumail(usr.getContact()));
		AvhUsergroup Ugrp = rep.getUGRep().findByAuser(usr);
		AvhGroup grp = rep.getGroupRep().findById(GroupType.STUDENT.toString()).get();
		Ugrp.setEgroup(grp);
		rep.getUGRep().save(Ugrp);
		rep.getUserRep().save(usr);
		
		resp.setNumail(usr.getNumail());
		resp.setUserid(userid);
		
		
		int test = this.CommonFunction.sendPendingRequestAndEmail("",usr.getContact().getEmail(),DigidConstants.TimeToExpiryForgetPassMail,EmailStatus.MAKE_STUDENT,DigidConstants.MakeStudent,usr.getUserid(),"M003");
		
		if(test == 1) {
			resp.setStatus(ErrorCode.Success);
		}
		
		return resp;
	}
	
	private String generateNumail(AvhContact ctt) {
		String numail = ctt.getFirstname()+"."+ctt.getLastname()+"@nuversity.com";
		AvhUser usr = rep.getUserRep().findByNumail(numail);
		if(usr == null) {
			return numail;
		}
		else {
			int ctr = 1;
			while(usr != null) {
				numail = ctt.getFirstname()+"."+ctt.getLastname()+ctr+"@nuversity.com";
				usr = rep.getUserRep().findByNumail(numail);
				ctr++;
			}
			return numail;
		}
	}
	
}
