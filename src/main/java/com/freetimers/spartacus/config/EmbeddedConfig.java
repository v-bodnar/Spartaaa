package com.freetimers.spartacus.config;

import com.freetimers.spartacus.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableMongoRepositories(basePackages = "com.freetimers.spartacus.repository")
@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class EmbeddedConfig {

    private TranslationService translationService;

    @Autowired
    public EmbeddedConfig(TranslationService translationService) {
        this.translationService = translationService;
    }


    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
//        converterList.add(new GladiatorConverter(translationService));
//        converterList.add(new SlaveConverter(translationService));
        converterList.add(new EquipConverter(translationService));
        converterList.add(new SchemeConverter(translationService));
        converterList.add(new ReactionConverter(translationService));
        return new MongoCustomConversions(converterList);

    }

}