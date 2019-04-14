package com.serli.workshop.functionnalprogrammation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import com.serli.workshop.functionnalprogrammation.repository.SerliansRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SerliansServiceTest {

    private SerliansService service;

    @Before
    public void setUp() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:serlians.json");

        SerliansRepository repository = new SerliansRepository(
                file,
                new ObjectMapper()
        );
        service = new SerliansService(repository);
    }

    @Ignore
    @Test
    public void shouldGetSerlians() {
        List<Serlian> serlians = service.getSerlians();
        assertThat(serlians).hasSize(199);
    }

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
        assertThat(roles).contains(
                "dev", "formateur", "speaker", "unknow", "tuteur", "president", "support"
        );
    }

}
