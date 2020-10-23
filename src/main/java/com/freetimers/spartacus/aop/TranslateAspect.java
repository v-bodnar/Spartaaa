package com.freetimers.spartacus.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.Optional;

@Aspect
@Component
public class TranslateAspect {
    private static final Logger LOG = LoggerFactory.getLogger(TranslateAspect.class);
    @Autowired
    private MessageSource messageSource;

    @PostConstruct
    public void setUp() {
        LOG.debug("aspect initilized");
    }

    @Around("@annotation(com.baeldung.LogExecutionTime)")
    public Object translate(ProceedingJoinPoint joinPoint) {
        try {
            Object translatable = joinPoint.proceed();
            if (translatable instanceof String) {
                String translatableString = (String) translatable;
                String defaultLanguage = messageSource.getMessage(translatableString, null, null, Locale.getDefault());
                String englishLanguage = Optional.ofNullable(defaultLanguage).
                        orElse(messageSource.getMessage(translatableString, null, null, Locale.US));
                return Optional.ofNullable(englishLanguage).orElse(String.format("No translation for:%s", translatableString));
            } else {
                return translatable;
            }

        } catch (Throwable throwable) {
            LOG.error("Translation error ", throwable);
            return null;
        }
    }
}
