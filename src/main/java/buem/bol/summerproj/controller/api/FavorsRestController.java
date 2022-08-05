package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Favors;
import buem.bol.summerproj.service.favors.impls.FavorsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/favors/")
@RestController
public class FavorsRestController {
    @Autowired
    FavorsServiceImpl service;


    @GetMapping("")
    public List<Favors> showAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Favors showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Favors insertOne(@RequestBody Favors favor){
        return service.create(favor);
    }
    @PutMapping()
    public Favors updateOne(@RequestBody Favors favor){
        return service.update(favor);
    }
}
