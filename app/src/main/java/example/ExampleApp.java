package example;

import net.rossillo.spring.web.mvc.CacheControlHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApp extends SpringBootServletInitializer {

    /**
     * Initializes this application when running as a standalone application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExampleApp.class, args);
    }

    /**
     * Initializes this application when running in a servlet container (e.g. Tomcat)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExampleApp.class);
    }

    @Bean
    public CacheControlHandlerInterceptor cacheControlHandlerInterceptor() {
        return new CacheControlHandlerInterceptor();
    }
}
