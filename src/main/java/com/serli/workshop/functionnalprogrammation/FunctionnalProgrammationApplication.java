package com.serli.workshop.functionnalprogrammation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.repository.SerliansRepository;
import com.serli.workshop.functionnalprogrammation.service.SerliansService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootApplication
public class FunctionnalProgrammationApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionnalProgrammationApplication.class, args);
    }

    @Bean
    SerliansRepository repository(ObjectMapper objectMapper) throws FileNotFoundException {
        return new SerliansRepository(
                ResourceUtils.getFile("classpath:data.json"),
                objectMapper
        );
    }

}
