package buem.bol.summerproj.controller.ui;

import buem.bol.summerproj.form.LoggerForm;
import buem.bol.summerproj.form.LoggerForm;
import buem.bol.summerproj.model.*;
import buem.bol.summerproj.service.agreement.impls.AgreementServiceImpl;
import buem.bol.summerproj.service.loger.impls.LoggerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/ui/v1/loggers/")
@Controller
public class LoggerUIController {

    @Autowired
    LoggerServiceImpl service;

    @Autowired
    AgreementServiceImpl agreementService;


    @GetMapping("")
    public String showAll(Model model) {
        List<Logger> loggers = service.getAll();

        model.addAttribute("loggers", loggers);
        return "loggers";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/ui/v1/loggers/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addLogger(Model model) {
        LoggerForm loggerForm = new LoggerForm();
        var names = agreementService.getAll()
                .stream()
                .map(agreement -> agreement.getName())
                .collect(Collectors.toList());
        model.addAttribute("names", names);
        model.addAttribute("form", loggerForm);

        return "addLogger";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLogger(Model model, @ModelAttribute("form") LoggerForm form) {
        String loggerName = form.getName();
        String name = form.getAgreement();
        double discount = 0;
        int numberAgreementsPerson = 0;


        Agreement agreementFromDB = agreementService.getAll()
                .stream().filter(agreement -> agreement.getName().equals(name))
                .findFirst().orElse(null);

        var agreementsForSamePerson = agreementService.getAll()
                .stream()
                .filter(agreement -> agreement.getClient().getName().equals(agreementFromDB.getClient().getName()))
                .collect(Collectors.toList());
        for(Agreement agreement: agreementsForSamePerson){
            numberAgreementsPerson += agreement.getFavors().size();
        }
        if(agreementFromDB.getFavors().size() >= 3){
            discount += 15;
        }
        if (numberAgreementsPerson % 5 == 0) {
            discount += 10;
        }
        Logger logger = new Logger();
        logger.setName(form.getName());
        logger.setAgreement(agreementFromDB);
        logger.setTransactionDate(form.getTransactionDate());
        logger.setDiscount(discount);
        logger.setSum(agreementFromDB.getSum() * (100 - discount) / 100);

        service.create(logger);


        return "redirect:/ui/v1/loggers/";
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public String updateLogger(Model model, @PathVariable("id") String id){
//        Logger loggersToUpdate = service.get(id);
//        LoggerForm loggersForm = new LoggerForm();
//
//        loggersForm.setId(loggersToUpdate.getId());
//        loggersForm.
////        loggersForm.setUpdatedAt(loggersToUpdate.getUpdatedAt());
////        loggersForm.setCreatedAt(loggersToUpdate.getCreatedAt());
//
//        model.addAttribute("form", loggersForm);
//        model.addAttribute("loggersnames", loggersnames);
//        return  "updateLogger";
//    }
//
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    public String updateLogger(@ModelAttribute("form") LoggerForm form){
//        Logger loggersToUpdate = new Logger();
//        loggersToUpdate.setId(form.getId());
//        loggersToUpdate.setLoggerName(form.getLoggerName());
//        loggersToUpdate.setPrice(form.getPrice());
//        loggersToUpdate.setDescription(form.getDescription());
////        loggersToUpdate.setCreatedAt(LocalDateTime.now());
////        loggersToUpdate.setUpdatedAt(LocalDateTime.now());
//        service.update(loggersToUpdate);
//
//        return  "redirect:/ui/v1/loggerss/";
//    }




}
