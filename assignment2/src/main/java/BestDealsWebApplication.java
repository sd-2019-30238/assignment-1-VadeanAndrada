package net.codeJava.BestDealsWeb;

import javax.xml.ws.RespectBinding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codeJava.BestDealsWeb.repository.UserRepository;

@SpringBootApplication
@EnableAutoConfiguration


public class BestDealsWebApplication {
	

		
	public static void main(String[] args) {
		SpringApplication.run(BestDealsWebApplication.class, args);
	}

}
