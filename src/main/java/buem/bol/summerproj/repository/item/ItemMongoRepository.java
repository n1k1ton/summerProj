package buem.bol.summerproj.repository.item;

import buem.bol.summerproj.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemMongoRepository extends MongoRepository<Item, String> {

    List<Item> findAllByCreatedAtAfterAndName(LocalDateTime date, String name);
}
