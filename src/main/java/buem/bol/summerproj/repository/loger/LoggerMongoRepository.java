package buem.bol.summerproj.repository.loger;

import buem.bol.summerproj.model.Logger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LoggerMongoRepository extends MongoRepository<Logger, String> {
    List<Logger> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
