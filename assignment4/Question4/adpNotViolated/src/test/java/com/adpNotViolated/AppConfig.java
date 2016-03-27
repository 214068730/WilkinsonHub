package com.adpNotViolated;

import com.adpNotViolated.manfacture.Manufacture;
import com.adpNotViolated.service.Honda;
import com.adpNotViolated.service.Nissan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/27.
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
