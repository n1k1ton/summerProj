package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Favor;
import buem.bol.summerproj.service.favor.impls.FavorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/favors/")
@RestController
public class FavorRestController {
    @Autowired
    FavorServiceImpl service;


    @GetMapping("")
    public List<Favor> showAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Favor showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Favor insertOne(@RequestBody Favor favor){
        return service.create(favor);
    }
    @PutMapping()
    public Favor updateOne(@RequestBody Favor favor){
        return service.update(favor);
    }
}
