package com.serli.workshop.functionnalprogrammation.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SerliansRepository {
    private static final Logger logger = LoggerFactory.getLogger(SerliansRepository.class);
    private final File serliansFile;
    private final ObjectMapper mapper;

    public SerliansRepository(File serliansFile, ObjectMapper mapper) {
        this.serliansFile = serliansFile;
        this.mapper = mapper;
    }

    public List<Serlian> getDataSerlian() {
        // TODO use try to handle error
        List<Serlian> serlians = new ArrayList<>();
        try {
            serlians = mapper.readValue(serliansFile, mapper.getTypeFactory().constructCollectionType(List.class, Serlian.class));
        } catch (Exception e) {
            logger.error("Could not load serlians from data.json", e);
        }
        return serlians;
    }
}
