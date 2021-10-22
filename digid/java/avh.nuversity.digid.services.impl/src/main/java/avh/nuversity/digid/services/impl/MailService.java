package avh.nuversity.digid.services.impl;

import java.util.Optional;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import avh.nuversity.digid.model.AvhMmesage;
import avh.nuversity.digid.services.impl.rep.AvhRep;

@Component
public class MailService {
    @Autowired
    private JavaMailSender mSender;

    @Autowired
	private AvhRep rep;
    
  
    
    @Value("${spring.mail.username}")
    private String mFrom;
    	
    public void sendMail(String to, String mailId, Properties ptes) throws Exception {
    	AvhMmesage m = getMailMessage(mailId);
    	
    	String subject = prepareMessage(m.getMsgSubject(), ptes);
    	String body = prepareMessage(m.getMsgBody(), ptes);
    	
    	MimeMessage msg = mSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setFrom(mFrom);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
        mSender.send(msg);
    }
    
     private String prepareMessage(String msg, Properties ptes) {
    	String res = msg;
    	for (String key : ptes.stringPropertyNames()) {
     		res = res.replaceAll("\\$" + key + "\\$", ptes.getProperty(key));
    	}
    	return res;
    }
    
    private AvhMmesage getMailMessage(String mid) {
    	Optional<AvhMmesage> m = rep.getMmrep().findById(mid);
    	if (m.isEmpty())
    		return null;
    	else
    		return m.get();
    }

}
