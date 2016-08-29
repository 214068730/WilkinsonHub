package composition;

import composition.services.IStudent;
import composition.services.Impl.StudentImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/21.
 */
@Configuration
public class AppConfig {


    @Bean(name="student")
    public IStudent getDetails(){

        return new StudentImpl();
    }

}
