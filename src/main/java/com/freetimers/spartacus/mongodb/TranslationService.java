package com.freetimers.spartacus.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class TranslationService {
    private MessageSource messageSource;

    @Autowired
    public TranslationService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String translate(String translatableString) {
        return Optional.ofNullable(messageSource.getMessage(translatableString, null, null, Locale.getDefault()))
                .orElseGet(() -> messageSource.getMessage(translatableString, null, String.format("No translation for:%s", translatableString), Locale.US));
    }
}
