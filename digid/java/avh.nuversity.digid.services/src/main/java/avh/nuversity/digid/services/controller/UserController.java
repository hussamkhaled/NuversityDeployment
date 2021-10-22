package avh.nuversity.digid.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import avh.nuversity.digid.model.AvhUser;
import avh.nuversity.digid.services.impl.UserControllerImpl;
import avh.nuversity.digid.services.impl.query.ChangeForgottenPasswordQuery;
import avh.nuversity.digid.services.impl.query.CreateUserQuery;
import avh.nuversity.digid.services.impl.query.ForgetPasswordQuery;
import avh.nuversity.digid.services.impl.query.ResetPasswordQuery;
import avh.nuversity.digid.services.impl.query.SetPasswordQuery;
import avh.nuversity.digid.services.impl.response.AuthenticateResponse;
import avh.nuversity.digid.services.impl.response.MakeStudentResponse;
import avh.nuversity.digid.services.impl.response.PendingRequestResponse;
import avh.nuversity.digid.services.impl.response.ResetPasswordResponse;

@RestController
public class UserController {
	@Autowired
	private UserControllerImpl svc;
	@Autowired
	private SendEmailService ses;
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/user/{id}")
	public AvhUser getUser(@PathVariable("id") String usrId) {
		return svc.getUser(usrId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/user")
	public String newUser(@RequestBody CreateUserQuery usr) {
		return svc.createUser(usr);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/login")
	public AuthenticateResponse authenticateUser(@RequestParam(value="email") String email, @RequestParam(value="pwd") String password) {
		return svc.authenticateUser(email, password);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/forgetPassword")
	public String postEmailforgetPassword(@RequestBody ForgetPasswordQuery usr) throws Exception {
		return svc.postEmailforgetPassword(usr);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/changeforgottenPassword")
	public PendingRequestResponse changeforgettenPassword(@RequestBody ChangeForgottenPasswordQuery usr) {
		return svc.changeforgettenPassword(usr);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/resetPassword")
	public ResetPasswordResponse resetPassword(@RequestBody ResetPasswordQuery usr) {
		return svc.resetPassword(usr);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/setPassword")
	public String setPassword(@RequestBody SetPasswordQuery usr) {
		return svc.setPassword(usr);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@GetMapping("/nuversity/api/digid/userByToken/{token}")
	public AvhUser getUserByToken(@PathVariable("token") String usrId) {
		return svc.getUserByToken(usrId);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/makeStudent")
	public MakeStudentResponse makeStudent(@RequestParam(value="userid") String userid) throws Exception {
		return svc.makeStudent(userid);
	}
	
	@CrossOrigin(origins =CORSTitle.React_Nuversity)
	@PostMapping("/nuversity/api/digid/sendEmail")
	public String sendEmail() {
		
		ses.sendEmail("hussam.h.khaled@gmail.com", "hello", "spring");
		return "Done";
	}
}
