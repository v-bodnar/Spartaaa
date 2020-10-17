package com.freetimers.spartacus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class LocaleTest {
    @Autowired
    private MessageSource messageSource;

    @Test
    public void localeTest() {
        ///when
        String englishTitle = messageSource.getMessage("card.setHandToPurpose.title", null, Locale.US);
        String russianTitle = messageSource.getMessage("card.setHandToPurpose.title", null, new Locale("ru"));
        //then
        assertEquals("Set hands to purpose", englishTitle);
        assertEquals("Не упуская возможности", russianTitle);
    }
}

