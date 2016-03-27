package com.assignment4OCP;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/23.
 */
@Configuration
public class AppConfig {

    @Bean(name="rectangle")
    public Rectangle getRectangle(){
        return new Rectangle(8,5);
    }

    @Bean(name="circle")
    public Circle getCircle(){
        return new Circle(5);
    }

    @Bean(name="calArea")
    public CalculateArea getArea(){
        return new CalculateArea();
    }
}
