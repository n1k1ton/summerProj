package buem.bol.summerproj.service.agreement.interfaces;

import buem.bol.summerproj.model.Agreement;

import java.util.List;

public interface IAgreementService {
    Agreement create(Agreement agreement);
    Agreement update(Agreement agreement);
    Agreement get(String id);
    void delete(String id);
    List<Agreement> getAll();
}
