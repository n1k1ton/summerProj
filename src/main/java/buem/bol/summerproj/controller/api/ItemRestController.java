package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Item;
import buem.bol.summerproj.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1/items/")
@RestController
public class ItemRestController {

    @Autowired
    ItemServiceImpl service;


    @GetMapping("")
    public List<Item> showAll(){
        return service.getAll();
    }
    @PostMapping("/all")
    public List<Item> saveAll(@RequestBody List<Item> items){
        return service.saveAll(items);
    }
    @GetMapping("/{id}")
    public Item showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Item insertOne(@RequestBody Item item){
        return service.create(item);
    }
    @PutMapping()
    public Item updateOne(@RequestBody Item item){
        return service.update(item);
    }



}
