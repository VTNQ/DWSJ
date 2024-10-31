package com.dwsj.api.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapConfiguration {
    @Bean
    public ModelMapper modelMap() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
