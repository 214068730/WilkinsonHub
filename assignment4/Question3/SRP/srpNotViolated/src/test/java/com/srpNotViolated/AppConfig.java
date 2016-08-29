package com.srpNotViolated;

import com.srpNotViolated.domain.PrintRectangle;
import com.srpNotViolated.service.IRectangle;
import com.srpNotViolated.service.Impl.RectangleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/23.
 */
@Configuration
public class AppConfig {

    @Bean(name="rectangle")
    public IRectangle getRectangle(){
        return new RectangleImpl();
    }

    @Bean(name="print")
    public PrintRectangle getPrintRectangle(){
        return new PrintRectangle();
    }
}
