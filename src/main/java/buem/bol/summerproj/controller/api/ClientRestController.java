package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Client;
import buem.bol.summerproj.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients/")
@RestController
public class ClientRestController {
    @Autowired
    ClientServiceImpl service;


    @GetMapping("")
    public List<Client> showAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Client showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Client insertOne(@RequestBody Client client){
        return service.create(client);
    }
    @PutMapping()
    public Client updateOne(@RequestBody Client client){
        return service.update(client);
    }
}
