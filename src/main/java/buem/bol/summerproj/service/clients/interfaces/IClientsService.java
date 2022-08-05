package buem.bol.summerproj.service.clients.interfaces;


import buem.bol.summerproj.model.Clients;

import java.util.List;

public interface IClientsService {
    Clients create(Clients client);
    Clients update(Clients client);
    Clients get(String id);
    void delete(String id);
    List<Clients> getAll();
}
