package br.com.rbsj.java_mongodb.repositories;

import br.com.rbsj.java_mongodb.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
}
