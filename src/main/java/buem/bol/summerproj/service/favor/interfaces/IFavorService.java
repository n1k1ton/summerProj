package buem.bol.summerproj.service.favor.interfaces;

import buem.bol.summerproj.model.Favor;

import java.util.List;

public interface IFavorService {
    Favor create(Favor favor);
    Favor update(Favor favor);
    Favor get(String id);
    void delete(String id);
    List<Favor> getAll();
}
