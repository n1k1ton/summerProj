package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Agreement;
import buem.bol.summerproj.service.agreement.impls.AgreementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1/agreements/")
@RestController
public class AgreementRestController {

    @Autowired
    AgreementServiceImpl service;


    @GetMapping("")
    public List<Agreement> showAll(){
        return service.getAll();
    }
    @PostMapping("/all")
    public List<Agreement> saveAll(@RequestBody List<Agreement> agreements){
        return service.saveAll(agreements);
    }
    @GetMapping("/{id}")
    public Agreement showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Agreement insertOne(@RequestBody Agreement agreement){
        return service.create(agreement);
    }
    @PutMapping()
    public Agreement updateOne(@RequestBody Agreement agreement){
        return service.update(agreement);
    }



}
