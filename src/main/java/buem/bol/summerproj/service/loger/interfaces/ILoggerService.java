package buem.bol.summerproj.service.loger.interfaces;

import buem.bol.summerproj.model.Logger;

import java.util.List;

public interface ILoggerService {
    Logger create(Logger logger);
    Logger update(Logger logger);
    Logger get(String id);
    void delete(String id);
    List<Logger> getAll();
}
