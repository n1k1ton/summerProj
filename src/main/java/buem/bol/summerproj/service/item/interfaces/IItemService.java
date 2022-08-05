package buem.bol.summerproj.service.item.interfaces;

import buem.bol.summerproj.model.Item;

import java.util.List;

public interface IItemService {
    // CRUD
    Item create(Item item);
    Item update(Item item);
    Item get(String id);
    void delete(String id);
    List<Item> getAll();
}
