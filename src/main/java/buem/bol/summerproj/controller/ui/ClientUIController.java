package buem.bol.summerproj.controller.ui;


import buem.bol.summerproj.form.ClientForm;
import buem.bol.summerproj.model.Client;
import buem.bol.summerproj.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/ui/v1/clients/")
@Controller
public class ClientUIController {

    @Autowired
    ClientServiceImpl service;


    @GetMapping("")
    public String showAll(Model model){
        model.addAttribute("clients", service.getAll());
        return "clients";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return  "redirect:/ui/v1/clients/";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addClient(Model model){
        ClientForm clientForm = new ClientForm();
        model.addAttribute("form", clientForm);
        return  "addClient";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("form") ClientForm form){
        Client client = new Client();
        client.setName(form.getName());
        client.setActivity(form.getActivity());
        client.setAddress(form.getAddress());
        client.setPhoneNumber(form.getPhoneNumber());
        service.create(client);
        return  "redirect:/ui/v1/clients/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateClient(Model model, @PathVariable("id") String id){
        Client clientToUpdate = service.get(id);
        ClientForm clientForm = new ClientForm();
        clientForm.setId(clientToUpdate.getId());
        clientForm.setName(clientToUpdate.getName());
        clientForm.setActivity(clientToUpdate.getActivity());
        clientForm.setAddress(clientToUpdate.getAddress());
        clientForm.setPhoneNumber(clientToUpdate.getPhoneNumber());
        clientForm.setUpdatedAt(clientToUpdate.getUpdatedAt());
        clientForm.setCreatedAt(clientToUpdate.getCreatedAt());

        model.addAttribute("form", clientForm);
        return  "updateClient";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateClient(@ModelAttribute("form") ClientForm form){
        Client clientToUpdate = new Client();
        clientToUpdate.setId(form.getId());
        clientToUpdate.setName(form.getName());
        clientToUpdate.setActivity(form.getActivity());
        clientToUpdate.setAddress(form.getAddress());
        clientToUpdate.setPhoneNumber(form.getPhoneNumber());
        clientToUpdate.setCreatedAt(form.getCreatedAt());
        clientToUpdate.setUpdatedAt(form.getUpdatedAt());
        service.update(clientToUpdate);

        return  "redirect:/ui/v1/clients/";
    }

}
