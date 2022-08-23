package buem.bol.summerproj.repository.clients;

import buem.bol.summerproj.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClientMongoRepository extends MongoRepository<Client, String> {
    List<Client> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
