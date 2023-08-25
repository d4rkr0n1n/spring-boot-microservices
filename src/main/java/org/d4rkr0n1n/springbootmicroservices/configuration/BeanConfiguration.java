package org.d4rkr0n1n.springbootmicroservices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public
    String getBeanConfigurationValue() {
        return "BeanConfigurationValue";
    }
 }