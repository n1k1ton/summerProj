package buem.bol.summerproj.repository.clients;

import buem.bol.summerproj.model.Clients;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientsFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Clients> clients = new ArrayList<>(Arrays.asList(
            new Clients("1", "Eduard Kolchan", "Programmer", "Mykolaiv, Ukraine, Lazurna st. 15",
                    "+380957862112", now, now),
            new Clients("2", "Alex Tulec","Sportsman", "Kyiv, Ukraine, Avtozavodska St, 24",
                    "+380957862111", now, now),
            new Clients("3", "Andrii Golovan","Not employed","Kyiv, Ukraine, Priorska St, 19Е",
                    "+380957862112" ,now, now)
    ));

    public List<Clients> findAll(){
        return this.clients;
    }


    public Clients findById(String id) {
        return this.clients.stream().filter(client -> client.getId().equals(id)).findFirst().orElse(null);
    }

    public Clients update(Clients client) {

        this.deleteById(client.getId());
        client.setUpdatedAt(LocalDateTime.now());
        this.clients.add(client);
        return client;
    }

    public void deleteById(String id) {
        Clients client = this.findById(id);
        this.clients.remove(client);
    }

    public Clients save(Clients client) {
        client.setId(UUID.randomUUID().toString());
        client.setCreatedAt(LocalDateTime.now());
        this.clients.add(client);
        return client;
    }

}
