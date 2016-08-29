package com.srpViolated;

import com.srpViolated.service.IRectangle;
import com.srpViolated.service.Impl.RectangleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/23.
 */
@Configuration
public class AppConfig {

    @Bean(name = "rectangle")
    public IRectangle getRectangle(){
        return new RectangleImpl();
    }
}
