package avh.nuversity.digid.services.controller;



import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



@Service
public class SendEmailService {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to,String body,String topic) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(to);
		smm.setSubject(topic);
		smm.setText(body);
		javaMailSender.send(smm);
	}
	
}
