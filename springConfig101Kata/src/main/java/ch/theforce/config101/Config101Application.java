package ch.theforce.config101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Config101Application {

	public static void main(String[] args) {
		SpringApplication.run(Config101Application.class, args);
	}
}

class ProgrammaticBeanDefinitionInitializr implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    public void initialize(GenericApplicationContext applicationContext) {

        BaaService baaService = new BaaService();
        FooService fooService = new FooService(baaService);
        applicationContext.registerBean(BaaService.class);
        applicationContext.registerBean(FooService.class, () -> fooService);
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