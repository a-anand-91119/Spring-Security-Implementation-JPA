package in.notyouraveragedev.jpasecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import in.notyouraveragedev.jpasecurity.models.User;
import in.notyouraveragedev.jpasecurity.repository.MyRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "in.notyouraveragedev.jpasecurity.repository" })
public class JpaSecurityApplication {

	@Autowired
	private MyRepository myRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@EventListener
	public void applicationReady(ApplicationReadyEvent event) {
		myRepository.save(new User("username", "password", "ROLE_USER"));
		myRepository.save(new User("user", "pass", "ROLE_USER"));
	}
}
