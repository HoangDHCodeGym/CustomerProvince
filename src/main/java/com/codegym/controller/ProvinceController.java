package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceRepository provinceRepository;

    @GetMapping("/province")
    public String provinceList(Model model, @ModelAttribute("message") String message) {
        Iterable<Province> provinceList = provinceRepository.findAll();
        model.addAttribute("provinceList", provinceList);
        return "/province/list-province";
    }

    @GetMapping("/create-province")
    public String createProvince(Model model) {
        Province province = new Province();
        model.addAttribute("province", province);
        return "/province/create-province";
    }

    @PostMapping("/create-province")
    public String saveProvince(@ModelAttribute("province") Province province, Model model) {
        provinceRepository.save(province);
        model.addAttribute("message", "Province saved successfully!");
        return "/province/create-province";
    }

    @GetMapping("/edit-province/{id}")
    public String editProvince(@PathVariable Long id, Model model) {
        Province province = provinceRepository.findOne(id);
        model.addAttribute("province", province);
        return "/province/edit-province";
    }

    @PostMapping("/edit-province/{id}")
    public String editedProvince(@ModelAttribute("province") Province province, Model model) {
        provinceRepository.save(province);
        model.addAttribute("message","Province name saved successfully");
        return "province/edit-province";
    }

    @GetMapping("delete-province/{id}")
    public String deleteProvince(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        provinceRepository.delete(id);
        redirectAttributes.addFlashAttribute("message", "Deleted Successfully!");
        return "redirect:/province";
    }
}
