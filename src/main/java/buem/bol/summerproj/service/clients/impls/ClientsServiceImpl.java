package buem.bol.summerproj.service.clients.impls;
import buem.bol.summerproj.model.Clients;
import buem.bol.summerproj.repository.clients.ClientsMongoRepository;
import buem.bol.summerproj.service.clients.interfaces.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ClientsServiceImpl implements IClientsService {
    private LocalDateTime now = LocalDateTime.now();
    private List<Clients> clients = new ArrayList<>(Arrays.asList(
            new Clients("1", "Eduard Kolchan", "Programmer", "Mykolaiv, Ukraine, Lazurna st. 15",
                    "+380957862112", now, now),
            new Clients("2", "Alex Tulec","Sportsman", "Kyiv, Ukraine, Avtozavodska St, 24",
                    "+380957862111", now, now),
            new Clients("3", "Andrii Golovan","Not employed","Kyiv, Ukraine, Priorska St, 19Е",
                    "+380957862112" ,now, now)
    ));

    @Autowired
    ClientsMongoRepository repository;
    //@PostConstruct
    void init(){
        //repository.saveAll(clients);
    }
    @Override
    public Clients create(Clients client) {
        client.setCreatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Clients update(Clients client) {
        client.setUpdatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Clients get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Clients> getAll() {
        return repository.findAll();
    }
}
