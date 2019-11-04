package br.com.rbsj.java_mongodb.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class Config {

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "trackzilla");
    }

    @Bean
    private MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

}
