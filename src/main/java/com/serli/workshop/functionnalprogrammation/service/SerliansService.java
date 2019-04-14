package com.serli.workshop.functionnalprogrammation.service;

import com.serli.workshop.functionnalprogrammation.dto.Evenement;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import com.serli.workshop.functionnalprogrammation.repository.SerliansRepository;
import io.vavr.collection.Map;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerliansService {

    private final SerliansRepository repository;

    public SerliansService(SerliansRepository repository) {
        this.repository = repository;
    }

    public List<Serlian> getSerlians(){
        return repository.getDataSerlian();
        // TODO
        //return null;
    }

    public Optional<Serlian> getSerlianById(String id){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public Optional<Serlian> getSerlianByName(String name){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public List<Serlian> getSerlianOrdorerByPrenom(){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public List<String> getDistinctRoles(){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public List<String> getSerlienByRole(String role){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public List<Evenement> getEventbySerlien(String id){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public Map<String, Integer> getSerlianEventHistogram() {
        repository.getDataSerlian();
        // TODO
        return null;
    }
}
