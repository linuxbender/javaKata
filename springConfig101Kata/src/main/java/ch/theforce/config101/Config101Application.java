package ch.theforce.config101;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Config101Application {

    public static class MyBDRPP implements BeanDefinitionRegistryPostProcessor {

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

            BeanFactory beanFactory = BeanFactory.class.cast(registry);

            registry.registerBeanDefinition("baaService",
                    BeanDefinitionBuilder.genericBeanDefinition(BaaService.class).getBeanDefinition());

            registry.registerBeanDefinition("fooService",
                    BeanDefinitionBuilder.genericBeanDefinition(FooService.class,
                            () -> new FooService(beanFactory.getBean(BaaService.class))).getBeanDefinition());
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        }
    }

	public static void main(String[] args) {
		SpringApplication.run(Config101Application.class, args);
	}
}

class ProgrammaticBeanDefinitionInitializr implements ApplicationContextInitializer<GenericApplicationContext> {

    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        applicationContext.registerBean(BaaService.class);
        applicationContext.registerBean(FooService.class, () -> new FooService(applicationContext.getBean(BaaService.class)));
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