package com.serli.workshop.functionnalprogrammation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Evenement;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import com.serli.workshop.functionnalprogrammation.service.SerliansService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/serlians")
public class SerliansController {
    Logger logger = LoggerFactory.getLogger(SerliansController.class);

    @Autowired
    private SerliansService serliansService;


    @GetMapping(path = "/", headers = "ordered=prenom")
    public ResponseEntity<List<Serlian>> getASerlianOrdoredByPrenom() {
        logger.info("getASerlianOrdoredByPrenom");
        // TODO
        return null;
    }


    @GetMapping(path = "/")
    public ResponseEntity<List<Serlian>> getSerlians(){
        logger.info("getSerlians");
        // TODO
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Serlian> getASerlian(@PathVariable String id) {
        logger.info("getASerlian");
        // TODO
        return null;

    }

    @GetMapping(path = "/roles")
    public ResponseEntity<List<String>> getDistinctRoles(){
        logger.info("getDistinctRoles");
        // TODO
        return null;
    }


    @GetMapping(path = "/{id}/evenements")
    public ResponseEntity<List<Evenement>> geteventsBySerlien(@PathVariable String id){
        logger.info("geteventsBySerlien");
        // TODO
        return null;
    }

    @PostMapping(path = "/")
    public ResponseEntity<List<Serlian>> getSerlienByRole(@RequestParam String role){
        logger.info("getSerlienByRole");
        // TODO
        return null;
    }


}
