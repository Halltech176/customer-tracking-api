package com.halltech.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMVC implements WebMvcConfigurer {

    @Value("#{'allowedOrigins}'.split(',')")
    private List<String> allowedOrigins;
//    @Override
    public void addCorsMapping(CorsRegistry registry){
       CorsRegistration corsRegistration = registry.addMapping("/api/**");
        allowedOrigins.forEach(corsRegistration::allowedOrigins);
    }
}
