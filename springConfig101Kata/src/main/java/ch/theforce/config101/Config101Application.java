package ch.theforce.config101;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Configuration
@ComponentScan
public class Config101Application {

    @Component
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