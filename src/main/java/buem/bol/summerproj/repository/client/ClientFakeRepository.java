package buem.bol.summerproj.repository.client;

import buem.bol.summerproj.model.Client;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ClientFakeRepository {
    private LocalDateTime now = LocalDateTime.now();
    private List<Client> clients = new ArrayList<>(Arrays.asList(
            new Client("1", "Eduard Kolchan", "Programmer", "Mykolaiv, Ukraine, Lazurna st. 15",
                    "+380957862112", now, now),
            new Client("2", "Alex Tulec","Sportsman", "Kyiv, Ukraine, Avtozavodska St, 24",
                    "+380957862111", now, now),
            new Client("3", "Andrii Golovan","Not employed","Kyiv, Ukraine, Priorska St, 19Е",
                    "+380957862112" ,now, now)
    ));

    public List<Client> findAll(){
        return this.clients;
    }


    public Client findById(String id) {
        return this.clients.stream().filter(client -> client.getId().equals(id)).findFirst().orElse(null);
    }

    public Client update(Client client) {

        this.deleteById(client.getId());
        client.setUpdatedAt(LocalDateTime.now());
        this.clients.add(client);
        return client;
    }

    public void deleteById(String id) {
        Client client = this.findById(id);
        this.clients.remove(client);
    }

    public Client save(Client client) {
        client.setId(UUID.randomUUID().toString());
        client.setCreatedAt(LocalDateTime.now());
        this.clients.add(client);
        return client;
    }

}
