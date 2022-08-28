package buem.bol.summerproj.service.client.impls;
import buem.bol.summerproj.model.Client;
import buem.bol.summerproj.repository.client.ClientMongoRepository;
import buem.bol.summerproj.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ClientServiceImpl implements IClientService {
    private LocalDateTime now = LocalDateTime.now();
    private List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("1", "Eduard Kolchan", "Programmer", "Mykolaiv, Ukraine, Lazurna st. 15",
                    "+380957862112", now, now),
            new Client("2", "Alex Tulec","Sportsman", "Kyiv, Ukraine, Avtozavodska St, 24",
                    "+380957862111", now, now),
            new Client("3", "Andrii Golovan","Not employed","Kyiv, Ukraine, Priorska St, 19Е",
                    "+380957862112" ,now, now)
    ));

    @Autowired
    ClientMongoRepository repository;
    @PostConstruct
    void init(){
        repository.saveAll(clients);
    }
    @Override
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        client.setUpdatedAt(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
