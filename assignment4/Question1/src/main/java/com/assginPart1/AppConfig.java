package com.assginPart1;

import com.assginPart1.domain.Person;
import com.assginPart1.services.Impl.PersonInfo;
import com.assginPart1.services.Impl.StudentDetails;
import com.assginPart1.services.PersonalInfo;
import com.assginPart1.services.StudentInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by student on 2016/03/20.
 */

@Configuration
public class AppConfig {

    @Bean(name="Person")
    public PersonalInfo getInfo() {
        return new PersonInfo();
    }

    @Bean(name="Student")
    public StudentInfo getStudent(){
        return new StudentDetails();
    }


}
