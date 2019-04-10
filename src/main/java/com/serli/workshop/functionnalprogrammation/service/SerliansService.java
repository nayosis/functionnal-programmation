package com.serli.workshop.functionnalprogrammation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Evenement;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import org.springframework.util.ResourceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SerliansService {

    final ObjectMapper mapper;

    public SerliansService(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Serlian> getSerlians(){
        getDataSerlian();
        // TODO
        return null;
    }

    public Optional<Serlian> getSerlianById(String id){
        getDataSerlian();
        // TODO
        return null;
    }

    public Optional<Serlian> getSerlianByName(String name){
        getDataSerlian();
        // TODO
        return null;
    }

    public List<Serlian> getSerlianOrdorerByPrenom(){
        getDataSerlian();
        // TODO
        return null;
    }

    public List<String> getDisctinctRole(){
        getDataSerlian();
        // TODO
        return null;
    }

    public List<String> getSerlienByRole(String role){
        getDataSerlian();
        // TODO
        return null;
    }

    public List<Evenement> getEventbySerlien(String id){
        getDataSerlian();
        // TODO
        return null;
    }

    private List<Serlian> getDataSerlian(){
        List<Serlian> serlians = new ArrayList<>();
        try {
            serlians = mapper.readValue(ResourceUtils.getFile("classpath:serlians.json"), mapper.getTypeFactory().constructCollectionType(List.class, Serlian.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serlians;
    }
}
