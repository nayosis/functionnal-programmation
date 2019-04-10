package com.serli.workshop.functionnalprogrammation.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SerliansRepository {
    private static final Logger logger = LoggerFactory.getLogger(SerliansRepository.class);
    private final ObjectMapper mapper;

    public SerliansRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Serlian> getDataSerlian() {
        List<Serlian> serlians = new ArrayList<>();
        try {
            serlians = mapper.readValue(ResourceUtils.getFile("classpath:serlians.json"), mapper.getTypeFactory().constructCollectionType(List.class, Serlian.class));
        } catch (Exception e) {
            logger.error("Could not load serlians from serlians.json", e);
        }
        return serlians;
    }
}
