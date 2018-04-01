package de.italoecu.webapp.de.italoecu.webapp.controllers;

import de.italoecu.webapp.de.italoecu.webapp.repositories.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BrandController {

    private BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @RequestMapping("italoecu/brands")
    public String getBrands(Model model){
        model.addAttribute("brands", this.brandRepository.findAll());
        return "brands";
    }

}
