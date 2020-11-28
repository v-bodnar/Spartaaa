package com.freetimers.spartacus.translation;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TranslationServiceTest {

    private static final Locale TEST_LOCALE_RU = new Locale("ru");

    private static final String TEST_KEY = "testKey";
    private static final String TEST_US_VALUE = "Syrian warrior";
    private static final String TEST_RU_VALUE = "Сирийский воин";

    @Mock
    public MessageSource messageSource;

    @Test
    public void translateSuccessfulUS() {
        //Given

        TranslationService translationService = new TranslationService(messageSource);
        Locale.setDefault(Locale.US);
        when(messageSource.getMessage(eq(TEST_KEY), isNull(), any(), eq(Locale.US))).thenReturn(TEST_US_VALUE);

        //When
        String translatedString = translationService.translate(TEST_KEY);

        //Then
        assertEquals(TEST_US_VALUE, translatedString);
    }

    @Test
    public void translateSuccessfulRU() {

        //Given
        TranslationService translationService = new TranslationService(messageSource);

        Locale.setDefault(TEST_LOCALE_RU);

        when(messageSource.getMessage(eq(TEST_KEY), isNull(), any(), eq(TEST_LOCALE_RU))).thenReturn(TEST_RU_VALUE);

        //When
        String translatedString = translationService.translate(TEST_KEY);

        //Then
        assertEquals(TEST_RU_VALUE, translatedString);

    }

    @Test
    public void translateSuccessfulDefault() {

        //Given
        TranslationService translationService = new TranslationService(messageSource);

        Locale.setDefault(TEST_LOCALE_RU);

        when(messageSource.getMessage(eq(TEST_KEY), isNull(), any(), eq(TEST_LOCALE_RU))).thenReturn(null);
        when(messageSource.getMessage(eq(TEST_KEY), isNull(), any(), eq(Locale.US))).thenReturn(TEST_US_VALUE);

        //When
        String translatedString = translationService.translate(TEST_KEY);

        //Then
        assertEquals(TEST_US_VALUE, translatedString);
    }

    @Test
    public void translateFail() {

        //Given
        TranslationService translationService = new TranslationService(messageSource);

        Locale.setDefault(Locale.CANADA_FRENCH);

        when(messageSource.getMessage(eq(TEST_KEY), isNull(), any(), eq(Locale.CANADA_FRENCH))).thenReturn(null);
        when(messageSource.getMessage(eq(TEST_KEY), isNull(), any(), eq(Locale.US))).thenReturn(String.format("No translation for:%s", TEST_KEY));

        //When
        String translatedString = translationService.translate(TEST_KEY);

        //Then
        assertEquals(String.format("No translation for:%s", TEST_KEY), translatedString);
    }
}
