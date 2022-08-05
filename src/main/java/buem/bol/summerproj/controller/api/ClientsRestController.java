package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Clients;
import buem.bol.summerproj.service.clients.impls.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients/")
@RestController
public class ClientsRestController {
    @Autowired
    ClientsServiceImpl service;


    @GetMapping("")
    public List<Clients> showAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Clients showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Clients insertOne(@RequestBody Clients client){
        return service.create(client);
    }
    @PutMapping()
    public Clients updateOne(@RequestBody Clients client){
        return service.update(client);
    }
}
