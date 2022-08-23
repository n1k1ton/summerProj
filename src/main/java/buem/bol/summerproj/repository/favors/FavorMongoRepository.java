package buem.bol.summerproj.repository.favors;

import buem.bol.summerproj.model.Favor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface FavorMongoRepository extends MongoRepository<Favor, String> {
    List<Favor> findAllByCreatedAt(LocalDateTime date);
}
