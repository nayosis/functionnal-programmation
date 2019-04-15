package com.serli.workshop.functionnalprogrammation.service;

import com.serli.workshop.functionnalprogrammation.dto.Evenement;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import com.serli.workshop.functionnalprogrammation.repository.SerliansRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

@Service
public class SerliansService {

    private final SerliansRepository repository;

    public SerliansService(SerliansRepository repository) {
        this.repository = repository;
    }

    public List<Serlian> getSerlians(){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    public Optional<Serlian> getSerlianById(String id){
        return repository.getDataSerlian().stream().filter(serlian -> id.equals(serlian.getId())).findFirst();
        // TODO
        //return null;
    }

    public Optional<Serlian> getSerlianByName(String name){
        repository.getDataSerlian();
        // TODO
        return null;
    }

    // TODO refactor getSerlianById & getSerlianByName to use
    //  pure functions
    //  &
    //  higher order functions

    public List<Serlian> getSerlianOrdorerByPrenom(){
        return repository.getDataSerlian().stream().sorted(Comparator.comparing(Serlian::getPrenom)).collect(Collectors.toList());
        // TODO
    }

    public List<String> getDistinctRoles(){
        return repository.getDataSerlian().stream().flatMap(serlian -> serlian.getRoles().stream()).distinct().collect(Collectors.toList());
        // TODO
    }

    public List<Serlian> getSerlienByRole(String role){
        return repository.getDataSerlian().stream().filter(serlian -> serlian.getRoles().contains(role)).collect(Collectors.toList());
        // TODO
    }

    public List<Evenement> getEventbySerlien(String id){
        return getSerlianById(id).map(Serlian::getEvenements).orElseThrow(()-> new IllegalStateException("aucun serlien a ce numero"));
        // TODO With a either ??
    }

    public java.util.Map<String, Integer> getSerlianEventHistogram() {
        java.util.Map<String, Integer> histogram = repository.getDataSerlian().stream()
                .flatMap(serlain -> serlain.getEvenements().stream())
                .collect(Collectors.groupingBy(
                        event -> event.getType(),
                        Collectors.mapping(event -> 1, Collectors.summingInt(entier -> (int) entier))
                ));

        // TODO
        return histogram;
    }

    public void addSerlian(Serlian serlian) {
        // TODO
    }

    public Serlian updateSerlian(Serlian serlian) {
        // TODO
        return null;
    }
}
