package com.freetimers.spartacus.config;

import com.freetimers.spartacus.translation.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.freetimers.spartacus.repository")
@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class EmbeddedConfig {

    private final TranslationService translationService;

    @Value("mongodb://${spring.data.mongodb.host}:${spring.data.mongodb.port}")
    private String mongoConnectionString;

    @Autowired
    public EmbeddedConfig(TranslationService translationService) {
        this.translationService = translationService;
    }

//    @Bean
//    public MongoDatabaseFactory factory() {
//        // also possible to connect to a remote or real MongoDB instance
//        ConnectionString connectionString = new ConnectionString(mongoConnectionString);
//        MongoDatabaseFactory mongoDbFactory = new SimpleMongoClientDatabaseFactory(connectionString);
//        return mongoDbFactory;
//    }


//    @Bean
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory factory) {
//        MongoTemplate template = new MongoTemplate(factory);
//        return template;
//    }

//
//    @Bean
//    public MongoCustomConversions mongoCustomConversions() {
//        List<Converter<?, ?>> converterList = new ArrayList<>();
////        converterList.add(new GladiatorConverter(translationService));
////        converterList.add(new SlaveConverter(translationService));
//        converterList.add(new EquipConverter(translationService));
//        converterList.add(new SchemeConverter(translationService));
//        converterList.add(new ReactionConverter(translationService));
//        return new MongoCustomConversions(converterList);
//
//    }

}