package com.serli.workshop.functionnalprogrammation.service;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextCapitalisationTest {

    /**
     * Work with pure functions
     */

    @Ignore
    @Test
    public void shouldCapitalize() {
        String text = "MAY the FoRce Be wITH YoU !";
        assertThat(capitalize(text)).isEqualTo("May The Force Be With You !");
    }

    @Ignore
    @Test
    public void shouldCapitalizeIgnoringSomeWords() {
        String text = "MAY the FoRce Be wITH YOU !";
        String[] ignoredWords = "force, you".split(",");

        assertThat(capitalize(text, ignoredWords)).isEqualTo("May The FoRce Be With YOU !");
    }

    private String capitalize(String text, String[] ignoredWords) {
        return null;
    }

    private String capitalize(String text) {
        return null;
    }

}
