package com.rideSharingApp.RideSharingApp.sride.createBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class ObjectMapperBean {

    @Bean
    public ObjectMapper getObjectMapperBean(){
        return new ObjectMapper();
    }
}
