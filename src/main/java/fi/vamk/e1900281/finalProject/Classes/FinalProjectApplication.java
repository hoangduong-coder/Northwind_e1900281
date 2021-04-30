package fi.vamk.e1900281.finalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")

public class FinalProjectApplication {
	public static void main(String... args) {
		SpringApplication app = new SpringApplication(FinalProjectApplication.class);
		app.setAdditionalProfiles("ssl");
		app.run(args);
	}
}
