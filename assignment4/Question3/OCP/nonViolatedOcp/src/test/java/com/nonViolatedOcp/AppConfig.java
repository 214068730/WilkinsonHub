package com.nonViolatedOcp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/23.
 */
@Configuration
public class AppConfig {

    @Bean(name="rectangle")
    public Shape getRectangle(){
        return new Rectangle(7,5);
    }

    @Bean(name="circle")
    public Shape getCircle(){
        return new Circle(2);
    }

    @Bean(name="calArea")
    public CalculateArea getArea(){
        return new CalculateArea();
    }
}
