package buem.bol.summerproj.repository.favors;

import buem.bol.summerproj.model.Favors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface FavorsMongoRepository extends MongoRepository<Favors, String> {
    List<Favors> findAllByCreatedAt(LocalDateTime date);
}
