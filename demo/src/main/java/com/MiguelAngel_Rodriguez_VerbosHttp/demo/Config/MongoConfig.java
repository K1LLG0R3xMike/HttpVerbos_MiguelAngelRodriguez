package com.MiguelAngel_Rodriguez_VerbosHttp.demo.Config;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDatabaseFactory(), mongoConverter());
    }

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory() {
        String mongoUri = "mongodb+srv://miguelrc055:xvUqGbB9CH50HGcv@cluster0.jouofuv.mongodb.net/Grocerys?retryWrites=true&w=majority";
        return new SimpleMongoClientDatabaseFactory(MongoClients.create(mongoUri), "Grocerys");
    }

    @Bean
    public MongoConverter mongoConverter() {
        return new MappingMongoConverter(mongoDatabaseFactory(), new MongoMappingContext());
    }
}

