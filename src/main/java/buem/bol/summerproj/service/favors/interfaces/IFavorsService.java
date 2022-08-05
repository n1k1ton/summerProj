package buem.bol.summerproj.service.favors.interfaces;

import buem.bol.summerproj.model.Favors;

import java.util.List;

public interface IFavorsService {
    Favors create(Favors favor);
    Favors update(Favors favor);
    Favors get(String id);
    void delete(String id);
    List<Favors> getAll();
}
