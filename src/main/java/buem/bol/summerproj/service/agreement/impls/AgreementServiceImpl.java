package buem.bol.summerproj.service.agreement.impls;

import buem.bol.summerproj.model.Agreement;
import buem.bol.summerproj.model.Favor;
import buem.bol.summerproj.repository.agreement.AgreementMongoRepository;
import buem.bol.summerproj.service.agreement.interfaces.IAgreementService;
import buem.bol.summerproj.service.client.impls.ClientServiceImpl;
import buem.bol.summerproj.service.favor.impls.FavorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class AgreementServiceImpl implements IAgreementService {
    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    FavorServiceImpl favorService;
    @Autowired
    AgreementMongoRepository repository;

    LocalDateTime now = LocalDateTime.now();



//    @PostConstruct
//    void init(){
//        List<Agreement> agreements = new ArrayList<>();
//        List<Favor> favors = new ArrayList<>();
//        Favor favor1 = favorService.get("1");
//        Favor favor2 = favorService.get("2");
//        favors.add(favor1);
//        favors.add(favor2);
//        agreements.add(new Agreement("1","Agreement 1",clientService.get("1"),favors, 100.0, 10.0, "agreement1 desc", now, now));
//        agreements.add(new Agreement("2","Agreement 2",clientService.get("2"),favors, 200.0, 20.0, "agreement2 desc", now, now));
//        repository.saveAll(agreements);
//    }


    @Override
    public Agreement create(Agreement agreement) {
        agreement.setCreatedAt(LocalDateTime.now());
        return repository.save(agreement);
    }

    @Override
    public Agreement update(Agreement agreement) {
        agreement.setUpdatedAt(LocalDateTime.now());
        return repository.save(agreement);
    }

    @Override
    public Agreement get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Agreement> getAll() {
        return repository.findAll();
    }

    public List<Agreement> saveAll(List<Agreement> agreements) {
        return repository.saveAll(agreements);
    }
}
