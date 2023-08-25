package org.d4rkr0n1n.springbootmicroservices.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.d4rkr0n1n.springbootmicroservices.configuration.BeanConfiguration;
import org.d4rkr0n1n.springbootmicroservices.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(Controller.class)
@EnableConfigurationProperties(value = {PropertiesConfiguration.class})
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BeanConfiguration beanConfiguration;

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Test
    void testGetValue() throws Exception{
        Map<String, String> output = new HashMap<>();
        output.put("test", "success");
        output.put("config", propertiesConfiguration.getValue());
        output.put("beanConfiguration", beanConfiguration.getBeanConfigurationValue());
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.test").value("success"));
    }
}
