package avh.nuversity.digid.services;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
@EntityScan(basePackages={"avh.nuversity.digid.model"})
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		/*
		AvhContact ct = new AvhContact();
		ct.setEmail("hmesper@gmail.com");
		ct.setCaddress("FRANCE");
		ct.setDob(new Timestamp(System.currentTimeMillis()));
		ct.setFirstname("Hassan");
		ct.setMiddlename("M.");
		ct.setLastname("Esper");
		ct.setGender("Male");
		ct.setPhone("0561309362");
		ct.setPhoto("Nothing");
		ct.setTitle("Dr");

		UTest t = ctx.getBean(UTest.class);
		t.save(ct);
		AvhContact res = t.load("hmesper@gmail.com");
		System.out.println("Contact Gender is " + res.getGender());
		System.out.println("D O N E.");
		*/
	}

}
