package br.com.rbsj.java_mongodb.repositories;

import br.com.rbsj.java_mongodb.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository  extends MongoRepository<Application, String> {
}
