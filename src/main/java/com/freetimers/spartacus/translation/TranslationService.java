package com.freetimers.spartacus.translation;

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

    /**
     * @param translatableKey-key for which translation service will search translation
     * @return returns translated String for given key;
     */
    public String translate(String translatableKey) {
        return Optional.ofNullable(messageSource.getMessage(translatableKey, null, null, Locale.getDefault()))
                .orElseGet(() -> messageSource.getMessage(translatableKey, null, String.format("No translation for:%s", translatableKey), Locale.US));
    }
}
