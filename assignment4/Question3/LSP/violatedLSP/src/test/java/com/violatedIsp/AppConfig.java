package com.violatedIsp;

import com.violatedIsp.service.IDove;
import com.violatedIsp.service.IOstrich;
import com.violatedIsp.service.Impl.DoveImpl;
import com.violatedIsp.service.Impl.OstrichImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/24.
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
