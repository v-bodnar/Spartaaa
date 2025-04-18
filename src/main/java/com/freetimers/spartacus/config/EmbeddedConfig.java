//package com.freetimers.spartacus.config;
//
//import com.freetimers.spartacus.mongodb.ClassDocumentConverter;
//import com.freetimers.spartacus.mongodb.DocumentClassConverter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.core.env.MutablePropertySources;
//import org.springframework.core.env.PropertySource;
//import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@EnableMongoRepositories(basePackages = "com.freetimers.spartacus.repository")
//@Configuration
//@EnableConfigurationProperties({MongoProperties.class, EmbeddedMongoProperties.class})
//public class EmbeddedConfig extends EmbeddedMongoAutoConfiguration {
//
//    private static MongodConfig mongodConfig;
//    private static MongodExecutable mongodExecutable;
//    private final MongoProperties properties;
//    private final ApplicationContext context;
//
//    public EmbeddedConfig(MongoProperties properties,
//                          ApplicationContext context) {
//        super(properties);
//        this.properties = properties;
//        this.context = context;
//    }
//
//    @Bean
//    public MongoCustomConversions mongoCustomConversions() {
//        List<Converter<?, ?>> converterList = new ArrayList<>();
//        converterList.add(new DocumentClassConverter());
//        converterList.add(new ClassDocumentConverter());
//        return new MongoCustomConversions(converterList);
//    }
//
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    @ConditionalOnMissingBean
//    @Override
//    public MongodExecutable embeddedMongoServer(MongodConfig mongodConfig, RuntimeConfig runtimeConfig,
//                                                ApplicationContext context) {
//        Integer configuredPort = this.properties.getPort();
//        if (configuredPort == null || configuredPort == 0) {
//            setEmbeddedPort(mongodConfig.net().getPort());
//        }
//        if (mongodExecutable != null) {
//            return mongodExecutable;
//        }
//        SingleInstanceMongodStarter singleInstanceMongodStarter = new SingleInstanceMongodStarter(runtimeConfig);
//        mongodExecutable = singleInstanceMongodStarter.prepare(mongodConfig);
//        return mongodExecutable;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    @Override
//    public MongodConfig embeddedMongoConfiguration(EmbeddedMongoProperties embeddedProperties) throws IOException {
//        if (mongodConfig != null) {
//            return mongodConfig;
//        }
//        mongodConfig = super.embeddedMongoConfiguration(embeddedProperties);
//        return mongodConfig;
//    }
//
//    private void setEmbeddedPort(int port) {
//        setPortProperty(this.context, port);
//    }
//
//    private void setPortProperty(ApplicationContext currentContext, int port) {
//        if (currentContext instanceof ConfigurableApplicationContext) {
//            MutablePropertySources sources = ((ConfigurableApplicationContext) currentContext)
//                    .getEnvironment().getPropertySources();
//            getMongoPorts(sources).put("local.mongo.port", port);
//        }
//        if (currentContext.getParent() != null) {
//            setPortProperty(currentContext.getParent(), port);
//        }
//    }
//
//    private Map<String, Object> getMongoPorts(MutablePropertySources sources) {
//        PropertySource<?> propertySource = sources.get("mongo.ports");
//        if (propertySource == null) {
//            propertySource = new MapPropertySource("mongo.ports",
//                    new HashMap<>());
//            sources.addFirst(propertySource);
//        }
//        return (Map<String, Object>) propertySource.getSource();
//    }
//
//    private static class SingleInstanceMongodStarter extends Starter<MongodConfig, MongodExecutable, MongodProcess> {
//
//        public SingleInstanceMongodStarter(RuntimeConfig config) {
//            super(config);
//        }
//
//        @Override
//        protected MongodExecutable newExecutable(MongodConfig config, Distribution distribution, RuntimeConfig runtime, ExtractedFileSet exe) {
//            try {
//                return new SingleInstanceMongodExecutable(config, runtime);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private static class SingleInstanceMongodExecutable extends MongodExecutable {
//
//        private MongodProcess process;
//        private final AtomicInteger counter = new AtomicInteger(0);
//
//        public SingleInstanceMongodExecutable(MongodConfig mongodConfig, RuntimeConfig runtimeConfig) throws IOException {
//            super(
//                    detectFor(mongodConfig.version()),
//                    mongodConfig,
//                    runtimeConfig,
//                    runtimeConfig.artifactStore().extractFileSet(detectFor(mongodConfig.version())).orElseThrow(() -> new RuntimeException("Can't set up mongo"))
//            );
//        }
//
//        @Override
//        protected MongodProcess start(Distribution distribution, MongodConfig config, RuntimeConfig runtime) throws IOException {
//            synchronized (counter) {
//                if (counter.get() > 0) {
//                    counter.incrementAndGet();
//                    return process;
//                }
//                process = super.start(distribution, config, runtime);
//                counter.incrementAndGet();
//                return process;
//            }
//        }
//
//        @Override
//        public synchronized void stop() {
//            synchronized (counter) {
//                if (counter.decrementAndGet() == 0) {
//                    super.stop();
//                }
//            }
//        }
//    }
//}
