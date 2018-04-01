package de.italoecu.webapp.de.italoecu.webapp.controllers;

import de.italoecu.webapp.de.italoecu.webapp.repositories.ModelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {

    private ModelRepository modelRepository;

    public ModelController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @RequestMapping("italoecu/models")
    public String getModels(Model model){
        model.addAttribute("models", modelRepository.findAll());
        return "models";
    }
}
