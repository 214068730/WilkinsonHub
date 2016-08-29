package com.plkViolated;

import com.plkViolated.services.IDrummer;
import com.plkViolated.services.ISinger;
import com.plkViolated.services.Impl.DrummerImpl;
import com.plkViolated.services.Impl.SingerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/26.
 */
@Configuration
public class AppConfig {

    @Bean(name="singer")
    public ISinger getSinger(){
        return new SingerImpl();
    }

    @Bean(name="drummer")
    public IDrummer getDrummer(){
        return new DrummerImpl();
    }
}
