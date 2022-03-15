package br.com.projeto.lp2.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ConfigMongoDev {

    @Bean
    public MongoTemplate mongoTemplate() {

        return new MongoTemplate(getClient(), "barbershop");
    }

    private MongoClient getClient() {

        return MongoClients.create("mongodb+srv://admin:jPzFf9sWKE2gHPcw@cluster0.tr4hb.mongodb.net");
    }
}