package no.ensurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"no.ensurance"})
public class KlientApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlientApplication.class, args);
	}

}
