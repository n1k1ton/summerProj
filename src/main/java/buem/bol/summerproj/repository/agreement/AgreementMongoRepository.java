package buem.bol.summerproj.repository.agreement;

import buem.bol.summerproj.model.Agreement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface AgreementMongoRepository  extends MongoRepository<Agreement, String> {
    List<Agreement> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
