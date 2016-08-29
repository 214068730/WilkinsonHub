package dipNotViolated;

import dipNotViolated.domain.Manufacture;
import dipNotViolated.service.Impl.Honda;
import dipNotViolated.service.Impl.Nissan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/22.
 */
@Configuration
public class AppConfig {


    @Bean(name="Honda")
    public Honda getHonda(){
        return new Honda();
    }


    @Bean(name="Nissan")
    public Nissan getNissan(){
        return new Nissan();
    }

    @Bean(name="Manufacture")
    public Manufacture getManufacture(){
        return new Manufacture();
    }


}
