package com.serli.workshop.functionnalprogrammation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serli.workshop.functionnalprogrammation.dto.Serlian;
import com.serli.workshop.functionnalprogrammation.repository.SerliansRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SerliansServiceTest {

    private SerliansService service;

    @Before
    public void setUp() {
        SerliansRepository repository = new SerliansRepository(new ObjectMapper());
        service = new SerliansService(repository);
    }

    @Ignore
    @Test
    public void shouldGetSerlians() {
        List<Serlian> serlians = service.getSerlians();
        assertThat(serlians).hasSize(18);
    }

}
