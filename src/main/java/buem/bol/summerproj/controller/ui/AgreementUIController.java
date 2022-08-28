package buem.bol.summerproj.controller.ui;

import buem.bol.summerproj.form.AgreementForm;
import buem.bol.summerproj.model.Agreement;
import buem.bol.summerproj.model.Client;
import buem.bol.summerproj.model.Favor;
import buem.bol.summerproj.service.agreement.impls.AgreementServiceImpl;
import buem.bol.summerproj.service.client.impls.ClientServiceImpl;
import buem.bol.summerproj.service.favor.impls.FavorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ui/v1/agreements/")
@Controller
public class AgreementUIController {

    @Autowired
    AgreementServiceImpl service;

    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    FavorServiceImpl favorService;


    @GetMapping("")
    public String showAll(Model model) {
        List<Agreement> agreements = service.getAll();

        model.addAttribute("agreements", agreements);
        return "agreements";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/agreements/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAgreement(Model model) {
        AgreementForm agreementForm = new AgreementForm();
        var names = clientService.getAll()
                .stream()
                .map(client -> client.getName())
                .collect(Collectors.toList());
        var favors = favorService.getAll()
                .stream()
                .map(favor -> favor.getDescription())
                .collect(Collectors.toList());
        model.addAttribute("favors", favors);
        model.addAttribute("names", names);
        model.addAttribute("form", agreementForm);

        return "addAgreement";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAgreement(Model model, @ModelAttribute("form") AgreementForm form) {
        String agreementName = form.getName();
        String name = form.getClient();
        String favorFromForm = form.getFavor();

        Agreement checkOldAgreement = service.getAll()
                .stream()
                .filter(agreement -> agreement.getName().equals(agreementName))
                .findFirst().orElse(null);

        Client clientFromDB = clientService.getAll()
                .stream().filter(client -> client.getName().equals(name))
                .findFirst().orElse(null);
        Favor favorFromDB = favorService.getAll()
                .stream().filter(favor -> favor.getDescription().equals(favorFromForm))
                .findFirst().orElse(null);

        if (checkOldAgreement != null && checkOldAgreement.getName().equals(agreementName)) {
            ArrayList<Favor> favorsToSet = new ArrayList<>();
            favorsToSet.addAll(0, checkOldAgreement.getFavors());
            favorsToSet.add(favorFromDB);
            checkOldAgreement.setFavors(favorsToSet);
            checkOldAgreement.setSum(CountSum(favorsToSet));
            if(form.getDescription() != ""){
                checkOldAgreement.setDescription(form.getDescription());
            }
            checkOldAgreement.setCommission(checkOldAgreement.getSum() * 0.1);
            service.update(checkOldAgreement);

        } else {
            ArrayList<Favor> favorsToSet = new ArrayList<>();
            favorsToSet.add(favorFromDB);
            Agreement agreement = new Agreement();
            agreement.setName(form.getName());
            agreement.setClient(clientFromDB);
            agreement.setFavors(favorsToSet);
            agreement.setDescription(form.getDescription());
            agreement.setSum(CountSum(favorsToSet));
            agreement.setCommission(agreement.getSum() * 0.1);
            service.create(agreement);
        }

        return "redirect:/ui/v1/agreements/";
    }




    public double CountSum(ArrayList<Favor> favorArrayList) {
        double sum = 0;
        for (Favor favor : favorArrayList) {
            sum += favor.getPrice();
        }
        return sum;

    }

}
