package buem.bol.summerproj.service.loger.impls;

import buem.bol.summerproj.model.Client;
import buem.bol.summerproj.model.Logger;
import buem.bol.summerproj.repository.loger.LoggerMongoRepository;
import buem.bol.summerproj.service.loger.interfaces.ILoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class LoggerServiceImpl implements ILoggerService {


    @Autowired
    LoggerMongoRepository repository;

    @PostConstruct
    void init(){
        //repository.saveAll(loggers);
    }
    @Override
    public Logger create(Logger logger) {
        logger.setCreatedAt(LocalDateTime.now());
        return repository.save(logger);
    }

    @Override
    public Logger update(Logger logger) {
        logger.setUpdatedAt(LocalDateTime.now());
        return repository.save(logger);
    }

    @Override
    public Logger get(String id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Logger> getAll() {
        return repository.findAll();
    }
}
