package ch.theforce.config101;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config101Application {

	@Bean
	FooService fooService (BaaService baaService) {
		return new FooService(baaService);
	}

	@Bean
	BaaService baaService() {
		return new BaaService();
	}

	public static void main(String[] args) {
		//SpringApplication.run(Config101Application.class, args);
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config101Application.class);
	}
}

class FooService {

	private final BaaService baaService;

	FooService(BaaService baaService) {
		this.baaService = baaService;
	}
}

class BaaService {

}