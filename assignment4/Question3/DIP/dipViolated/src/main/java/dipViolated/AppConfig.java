package dipViolated;

import dipViolated.badDipExample.Car;
import dipViolated.badDipExample.Manufacture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/22.
 */
@Configuration
public class AppConfig {



    @Bean(name="manufacture")
    public Manufacture getManufacture(){
        return new Manufacture();
    }

    @Bean(name="car")
    public Car getCar(){
        return new Car("Ford ST","CA54684",220);
    }

}
