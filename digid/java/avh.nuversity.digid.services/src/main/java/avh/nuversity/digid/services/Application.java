package avh.nuversity.digid.services;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
@EntityScan("avh.nuversity.digid.model")
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		
	}
                       
}


