package org.d4rkr0n1n.springbootmicroservices.controller;

import java.util.HashMap;
import java.util.Map;

import org.d4rkr0n1n.springbootmicroservices.configuration.BeanConfiguration;
import org.d4rkr0n1n.springbootmicroservices.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@Log
@RestController
public class Controller {

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Autowired
    BeanConfiguration beanConfiguration;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getValue() {
        Map<String, String> output = new HashMap<>();
        output.put("test", "success");
        output.put("config", propertiesConfiguration.getValue());
        output.put("beanConfiguration", beanConfiguration.getBeanConfigurationValue());

        log.info("Testing success !!");

        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
