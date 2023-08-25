package org.d4rkr0n1n.springbootmicroservices.configuration;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@ConfigurationProperties(prefix = "config")
@Data
public class PropertiesConfiguration {
    private String value;
}
