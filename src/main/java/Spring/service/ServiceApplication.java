package Spring.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = "Spring")
public class ServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceApplication.class, args);
	}

}
