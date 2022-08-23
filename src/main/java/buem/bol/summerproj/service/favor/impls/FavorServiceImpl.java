package buem.bol.summerproj.service.favor.impls;

import buem.bol.summerproj.model.Favor;
import buem.bol.summerproj.repository.favors.FavorMongoRepository;
import buem.bol.summerproj.service.favor.interfaces.IFavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class FavorServiceImpl implements IFavorService {

    private LocalDateTime now = LocalDateTime.now();
//    private List<Favors> favors = new ArrayList<>(Arrays.asList(
//            new Favors("1", FavorName.PowerOfAttorney, "Make a power of attorney", now, now),
//            new Favors("2", FavorName.LeaseSubleaseAgreement, "Lease agreement", now, now),
//            new Favors("3", FavorName.DocumentTranslationCertification,
//                    "Certificate document translated from Slovak language", now, now)
//    ));

    @Autowired
    FavorMongoRepository repository;
    //@PostConstruct
    void init(){
        //repository.saveAll(favors);
    }
    @Override
    public Favor create(Favor favor) {
        favor.setCreatedAt(LocalDateTime.now());
        return repository.save(favor);
    }

    @Override
    public Favor update(Favor favor) {
        favor.setUpdatedAt(LocalDateTime.now());
        return repository.save(favor);
    }

    @Override
    public Favor get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Favor> getAll() {
        return repository.findAll();
    }
}
