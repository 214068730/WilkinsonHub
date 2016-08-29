package com.IspNotViolated;

import com.IspNotViolated.service.IDove;
import com.IspNotViolated.service.IOstrich;
import com.IspNotViolated.service.Impl.DoveImpl;
import com.IspNotViolated.service.Impl.OstrichImpl;
import com.sun.istack.internal.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/24.
 */
@Configuration
public class AppConfig {

    @Bean(name ="dove")
    public IDove getDove(){
        return new DoveImpl();
    }

    @Bean(name="ostrich")
    public IOstrich getOstrich(){
        return new OstrichImpl();
    }
}
