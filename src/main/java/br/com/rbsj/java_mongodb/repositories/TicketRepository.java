package br.com.rbsj.java_mongodb.repositories;

import br.com.rbsj.java_mongodb.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findByStatus(String status);

    @Query("{ 'status' : ?0 }")
    Stream<Ticket> findAllByCustomerAndStream(String status);
}
