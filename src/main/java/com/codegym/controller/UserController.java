package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/")
    public String index(@ModelAttribute("message") String message, Model model) {
        Iterable<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message","Saved successfully!");
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        System.out.println(id);
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message", "Edited successfully!");
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        customerService.deleteById(id);
//        model.addAttribute("message", "Deleted successfully");
        redirectAttributes.addFlashAttribute("message", "Deleted successfully!");
        return "redirect:/";
    }

}
