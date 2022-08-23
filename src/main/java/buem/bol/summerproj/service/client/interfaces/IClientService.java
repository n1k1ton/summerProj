package buem.bol.summerproj.service.client.interfaces;


import buem.bol.summerproj.model.Client;

import java.util.List;

public interface IClientService {
    Client create(Client client);
    Client update(Client client);
    Client get(String id);
    void delete(String id);
    List<Client> getAll();
}
