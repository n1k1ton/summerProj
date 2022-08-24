package buem.bol.summerproj.controller.ui;


import buem.bol.summerproj.form.ItemForm;
import buem.bol.summerproj.model.Item;
import buem.bol.summerproj.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/ui/v1/items/")
@Controller
public class ItemUIController {

    @Autowired
    ItemServiceImpl service;


    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("items", service.getAll());
        return "items";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/items/";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addItem(Model model){
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form", itemForm);
        return  "addItem";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addItem(@ModelAttribute("form") ItemForm form){
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);
        return  "redirect:/ui/v1/items/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateItem(Model model, @PathVariable("id") String id){
        Item itemToUpdate = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(itemToUpdate.getId());
        itemForm.setName(itemToUpdate.getName());
        itemForm.setDescription(itemToUpdate.getDescription());
        itemForm.setUpdatedAt(itemToUpdate.getUpdatedAt());
        itemForm.setCreatedAt(itemToUpdate.getCreatedAt());

        model.addAttribute("form", itemForm);
        return  "updateItem";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateItem(@ModelAttribute("form") ItemForm form){
        Item itemToUpdate = new Item();
        itemToUpdate.setId(form.getId());
        itemToUpdate.setName(form.getName());
        itemToUpdate.setDescription(form.getDescription());
        itemToUpdate.setCreatedAt(LocalDateTime.now());
        itemToUpdate.setUpdatedAt(LocalDateTime.now());
        service.update(itemToUpdate);

        return  "redirect:/ui/v1/items/";
    }

}
