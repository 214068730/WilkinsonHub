package droid_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class App
{
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }
}
