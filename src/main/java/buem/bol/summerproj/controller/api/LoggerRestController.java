package buem.bol.summerproj.controller.api;

import buem.bol.summerproj.model.Logger;
import buem.bol.summerproj.service.loger.impls.LoggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api/v1/loggers/")
@RestController
public class LoggerRestController {

    @Autowired
    LoggerServiceImpl service;


    @GetMapping("")
    public List<Logger> showAll(){
        return service.getAll();
    }
    @PostMapping("/all")
    public List<Logger> saveAll(@RequestBody List<Logger> loggers){
        return service.saveAll(loggers);
    }
    @GetMapping("/{id}")
    public Logger showOne(@PathVariable String id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable String id){
        service.delete(id);
    }
    @PostMapping()
    public Logger insertOne(@RequestBody Logger agreement){
        return service.create(agreement);
    }
    @PutMapping()
    public Logger updateOne(@RequestBody Logger agreement){
        return service.update(agreement);
    }



}
