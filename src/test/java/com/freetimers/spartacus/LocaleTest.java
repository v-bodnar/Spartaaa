package com.freetimers.spartacus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.TestPropertySource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration")
public class LocaleTest {
    @Autowired
    private MessageSource messageSource;

    @Test
    public void localeTest() {
        ///when
        String englishTitle = messageSource.getMessage("card.schemeCard.setHandToPurpose.title", null, Locale.US);
        String russianTitle = messageSource.getMessage("card.schemeCard.setHandToPurpose.title", null, new Locale("ru"));
        //then
        assertEquals("Set hands to purpose", englishTitle);
        assertEquals("Не упуская возможности", russianTitle);
    }
}

