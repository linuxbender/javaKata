package ch.springBootRest.wildfly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfigurer implements WebMvcConfigurer {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("classpath:Messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // TODO: extract string to enums
        registry.addMapping("/partner/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Accept-Language")
                .allowCredentials(false).maxAge(3600);

        registry.addMapping("/partnerinfo/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("Accept-Language", "ETag")
                .allowCredentials(false).maxAge(3600);

        registry.addMapping("/translation/**")
                .allowedOrigins("*")
                .allowedMethods("GET")
                .allowedHeaders("Accept-Language", "ETag")
                .allowCredentials(false).maxAge(3600);
    }
}
