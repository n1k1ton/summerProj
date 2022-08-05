package buem.bol.summerproj.service.favors.impls;

import buem.bol.summerproj.model.FavorName;
import buem.bol.summerproj.model.Favors;
import buem.bol.summerproj.repository.favors.FavorsMongoRepository;
import buem.bol.summerproj.service.favors.interfaces.IFavorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FavorsServiceImpl implements IFavorsService {

    private LocalDateTime now = LocalDateTime.now();
    private List<Favors> favors = new ArrayList<>(Arrays.asList(
            new Favors("1", FavorName.PowerOfAttorney, "Make a power of attorney", now, now),
            new Favors("2", FavorName.LeaseSubleaseAgreement, "Lease agreement", now, now),
            new Favors("3", FavorName.DocumentTranslationCertification,
                    "Certificate document translated form Slovak language", now, now)
    ));

    @Autowired
    FavorsMongoRepository repository;
    //@PostConstruct
    void init(){
        //repository.saveAll(favors);
    }
    @Override
    public Favors create(Favors favor) {
        favor.setCreatedAt(LocalDateTime.now());
        return repository.save(favor);
    }

    @Override
    public Favors update(Favors favor) {
        favor.setUpdatedAt(LocalDateTime.now());
        return repository.save(favor);
    }

    @Override
    public Favors get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Favors> getAll() {
        return repository.findAll();
    }
}
