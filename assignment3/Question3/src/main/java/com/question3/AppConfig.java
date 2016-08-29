package com.question3;

import com.question3.services.CarInfo;
import com.question3.services.Impl.Bmw;
import com.question3.services.Impl.Ford;
import com.question3.services.Impl.Toyota;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/13.
 */
@Configuration
public class AppConfig {

    @Bean(name="Bmw")
    public CarInfo getBmw(){
        return new Bmw();
    }

    @Bean(name="Toyota")
    public CarInfo getToyota() {
        return new Toyota();
    }

    @Bean(name="Ford")
    public CarInfo getFord() {
        return new Ford();
    }



}
