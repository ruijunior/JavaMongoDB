package br.com.rbsj.java_mongodb.service;

import br.com.rbsj.java_mongodb.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addApplicationWTemplate(Application application) {
        mongoTemplate.insert(application);
    }

    @Override
    public Application findByIdTemplate(String id) {
        return this.mongoTemplate.findById(id, Application.class);
    }

    @Override
    public void deleteWTemplate(Application application) {
        this.mongoTemplate.remove(application);
    }

    @Override
    public void updateApplicationWTemplate(Application application, String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(application.getName()));

        Update update = new Update();
        update.set("name", name);

        mongoTemplate.updateFirst(query, update, Application.class);
    }
}
