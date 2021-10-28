package avh.nuversity.lms.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
@EntityScan(basePackages={"avh.nuversity.lms.model"})
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
	
	}

}
