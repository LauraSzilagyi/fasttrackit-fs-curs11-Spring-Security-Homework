package ro.fasttrackit.curs11homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs11homework.config.CredentialConfigurationReader;

@SpringBootApplication
public class Curs11HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Curs11HomeworkApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunnerConfiguration(CredentialConfigurationReader credentialConfigurationReader) {
//		return args -> {
//			credentialConfigurationReader
//		}
//	}
}
