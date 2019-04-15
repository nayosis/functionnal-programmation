package com.serli.workshop.functionnalprogrammation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Evenement;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import com.serli.workshop.functionnalprogrammation.repository.SerliansRepository;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Map;
import io.vavr.collection.Seq;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class SerliansServiceTest {

    private static final ObjectMapper mapper = new ObjectMapper();
    private SerliansRepository repository;
    private SerliansService service;

    @Before
    public void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:data.json");

        repository = new SerliansRepository(file, mapper);
        service = new SerliansService(repository);
    }

    /**
     * Work with map, flatMap, filter, fold ...
     */

    @Ignore
    @Test
    public void shouldGetSerlians() {
        List<Serlian> serlians = service.getSerlians();
        assertThat(serlians).hasSize(199);
    }

    /**
     * Work with Options
     */

    @Ignore
    @Test
    public void shouldGetOneSerlians() {
        Optional<Serlian> serlianById = service.getSerlianById("193cca81-3cee-4866-89ee-82f7f06a24d2");
        assertThat(serlianById).isNotEmpty();
        assertThat(serlianById).map(serlian -> serlian.getNom()).hasValue("Valentine");
    }

    @Ignore
    @Test
    public void shouldGetOneSerlians_NotFound() {
        Optional<Serlian> serlianById = service.getSerlianById("193cxxx-3cee-4866-89ee-82f7f06a24d2");
        assertThat(serlianById).isNotNull();
        assertThat(serlianById).isEmpty();
    }

    @Ignore
    @Test
    public void shouldGetRoles() {
        List<String> roles = service.getDistinctRoles();

        assertThat(roles).containsOnly(
                "Unknow", "Formateur", "Dev", "Support", "Tuteur", "President"
        );
    }


    @Ignore
     @Test
    public void shouldOrdored() {
        List<Serlian> serlians =  service.getSerlianOrdorerByPrenom();
        assertThat(serlians).isSortedAccordingTo(Comparator.comparing(Serlian::getPrenom));
    }

    @Ignore
    @Test
public void shouldGetSerlianByRole() {

    List<Serlian> serlians =  service.getSerlienByRole("Dev");
    assertThat(serlians).hasSize(51);

}

    @Ignore
    @Test
public void shouldGetEventByIdSerlian (){
    List<Evenement> eventbySerlien = service.getEventbySerlien("193cca81-3cee-4866-89ee-82f7f06a24d2");

    assertThat(eventbySerlien).hasSize(1);

}

    @Ignore
    @Test
    public void shouldGetErrorWithEventByIdSerlian (){

        assertThatCode(() -> service.getEventbySerlien("pasdetrouvation")).hasMessage("aucun serlien a ce numero");

    }



    /**
     * Work with fold, Tuple
     */

    @Ignore
    @Test
    public void shouldGetEventHistogram() {
        java.util.Map<String, Integer> histogram = service.getSerlianEventHistogram();
        assertThat(histogram).contains( entry("naissance enfant", 128),
                entry("Mission", 106),
                entry("Conf", 122),
                entry("Support", 122),
                entry("Formation", 117));
    }




    /**
     * Work with Eithers.
     */

    @Ignore
    @Test
    public void addSerlianInformation() {
        Serlian serlian = new Serlian();
        serlian.setNom("Foo");
        serlian.setPrenom("Bar");

        service.addSerlian(serlian);
        assertThat(service.getSerlians()).extracting("nom", "prenom")
                .contains(tuple("Foo", "Bar"));
    }

    @Ignore
    @Test
    public void addSerlianInformationShouldFailWhenSerlianAlreadyExists() {
        Serlian serlian = new Serlian();
        serlian.setNom("Denise");
        serlian.setPrenom("Rodgers");

        assertThatCode(() -> service.addSerlian(serlian))
                .hasMessage("Serlian Denise Rodgers already exists.");
    }

    @Ignore
    @Test
    public void updateSerlian() throws IOException {
        File updatedSerlianFile = ResourceUtils.getFile("classpath:updated_serlian.json");

        String updatedSerlianJson = new String(Files.readAllBytes(Paths.get("classpath:updated_serlian.json")), StandardCharsets.UTF_8);

        Serlian serlian = mapper.readValue(updatedSerlianFile, Serlian.class);
        Serlian updatedSerlian = service.updateSerlian(serlian);

        assertThat(mapper.writeValueAsString(updatedSerlian))
                .isEqualTo(updatedSerlianJson);

        assertThat(service.getSerlians()).contains(serlian);
    }

    @Ignore
    @Test
    public void updateSerlianShouldFailWhenMissingSerlian() throws IOException {
        Serlian serlian = new Serlian();
        serlian.setId("should-not-be-found");

        assertThatCode(() -> service.updateSerlian(serlian))
                .hasMessage("Serlian 'should-not-be-found' does not exists.");
    }



}
