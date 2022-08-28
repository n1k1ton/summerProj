package buem.bol.summerproj.service.favor.impls;

import buem.bol.summerproj.model.Favor;
import buem.bol.summerproj.model.FavorName;
import buem.bol.summerproj.repository.favor.FavorMongoRepository;
import buem.bol.summerproj.service.favor.interfaces.IFavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FavorServiceImpl implements IFavorService {

    private LocalDateTime now = LocalDateTime.now();
    private List<Favor> favors = new ArrayList<>(Arrays.asList(
            new Favor("1", FavorName.PowerOfAttorney, "Power of Attorney", 30, now, now),
            new Favor("2", FavorName.NotaryConsultation, "Notary Consultation", 5, now, now),
            new Favor("3", FavorName.DonationAgreement,"Donation agreement",250 , now, now),
            new Favor("4", FavorName.CertificationCopyDocument,"Make certified copy of document",10 , now, now),
            new Favor("5", FavorName.ContractSale,"Agreement of sale",150 , now, now),
            new Favor("6", FavorName.LoanAgreement,"Loan agreement",50 , now, now),
            new Favor("7", FavorName.DocumentCertification,"Certificate document",10 , now, now),
            new Favor("8", FavorName.LeaseSubleaseAgreement,"Lease agreement", 100, now, now),
            new Favor("9", FavorName.DocumentTranslationCertification,"Translation and certification of the document",40 , now, now)
    ));
    @Autowired
    FavorMongoRepository repository;
//    @PostConstruct
//    void init(){
//        repository.saveAll(favors);
//    }
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
