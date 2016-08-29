package com.lspNotViolated;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/22.
 */
@Configuration
public class AppConfig {

    @Bean(name="Rec")
    public Rectangle getRectangle(){
        return new Rectangle(7,5);
    }

    @Bean(name="square")
    public Square getSquare(){
        return new Square(5);
    }
}
