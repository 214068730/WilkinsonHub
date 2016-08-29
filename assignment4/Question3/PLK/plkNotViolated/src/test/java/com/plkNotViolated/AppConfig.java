package com.plkNotViolated;

import com.plkNotViolated.service.IDrummer;
import com.plkNotViolated.service.ISinger;
import com.plkNotViolated.service.Impl.DrummerImpl;
import com.plkNotViolated.service.Impl.SingerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/27.
 */@Configuration
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
