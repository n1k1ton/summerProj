package buem.bol.summerproj.repository.clients;

import buem.bol.summerproj.model.Clients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClientsMongoRepository extends MongoRepository<Clients, String> {
    List<Clients> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
