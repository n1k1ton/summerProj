package buem.bol.summerproj.controller.ui;


import buem.bol.summerproj.form.FavorForm;
import buem.bol.summerproj.model.Favor;
import buem.bol.summerproj.model.FavorName;
import buem.bol.summerproj.service.favor.impls.FavorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/ui/v1/favors/")
@Controller
public class FavorUIController {

    @Autowired
    FavorServiceImpl service;


    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("favors", service.getAll());
        return "favors";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/favors/";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFavor(Model model){
        FavorForm favorForm = new FavorForm();
        var favornames = FavorName.values();
        model.addAttribute("form", favorForm);
        model.addAttribute("favornames", favornames);
        return  "addFavor";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFavor(@ModelAttribute("form") FavorForm form){
        Favor favor = new Favor();
        favor.setFavorName(form.getFavorName());
        favor.setPrice(form.getPrice());
        favor.setDescription(form.getDescription());
        service.create(favor);
        return  "redirect:/ui/v1/favors/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateFavor(Model model, @PathVariable("id") String id){
        Favor favorToUpdate = service.get(id);
        FavorForm favorForm = new FavorForm();
        var favornames = FavorName.values();
        favorForm.setId(favorToUpdate.getId());
        favorForm.setFavorName(favorToUpdate.getFavorName());
        favorForm.setPrice(favorToUpdate.getPrice());
        favorForm.setDescription(favorToUpdate.getDescription());
//        favorForm.setUpdatedAt(favorToUpdate.getUpdatedAt());
//        favorForm.setCreatedAt(favorToUpdate.getCreatedAt());

        model.addAttribute("form", favorForm);
        model.addAttribute("favornames", favornames);
        return  "updateFavor";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateFavor(@ModelAttribute("form") FavorForm form){
        Favor favorToUpdate = new Favor();
        favorToUpdate.setId(form.getId());
        favorToUpdate.setFavorName(form.getFavorName());
        favorToUpdate.setPrice(form.getPrice());
        favorToUpdate.setDescription(form.getDescription());
//        favorToUpdate.setCreatedAt(LocalDateTime.now());
//        favorToUpdate.setUpdatedAt(LocalDateTime.now());
        service.update(favorToUpdate);

        return  "redirect:/ui/v1/favors/";
    }

}
