package com.ispViolated;

import com.ispViolated.services.IDove;
import com.ispViolated.services.IOstrich;
import com.ispViolated.services.Impl.DoveImpl;
import com.ispViolated.services.Impl.OstrichImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/27.
 */
@Configuration
public class AppConfig {

    @Bean(name="dove")
    public IDove getDove(){
        return new DoveImpl();
    }

    @Bean(name="ostrich")
    public IOstrich getOstrich(){
        return new OstrichImpl();
    }
}

