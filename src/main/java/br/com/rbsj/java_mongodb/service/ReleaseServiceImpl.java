package br.com.rbsj.java_mongodb.service;

import br.com.rbsj.java_mongodb.model.Release;
import br.com.rbsj.java_mongodb.repositories.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public List<Release> getReleaseByTicketStatus(String status) {
        Query query = new Query();

        query.addCriteria(Criteria.where("tickets.status").is(status));

        return (List<Release>) mongoTemplate.findById(query, Release.class);
    }

    @Override
    public Release save(Release release) {
        return this.releaseRepository.save(release);
    }
}
