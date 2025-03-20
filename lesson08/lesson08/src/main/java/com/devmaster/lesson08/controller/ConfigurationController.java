package com.devmaster.lesson08.controller;

import com.devmaster.lesson08.entity.Configuration;
import com.devmaster.lesson08.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/configurations")
public class ConfigurationController {
    @Autowired
    private ConfigurationService configurationService;

    @GetMapping
    public String configurations(Model model) {
        model.addAttribute("configuration",configurationService.getAllConfigurations());
        return "configurations";
    }
    @GetMapping("/new")
    public String newConfiguration(Model model) {
        model.addAttribute("configuration",new Configuration());
        model.addAttribute("configurations", configurationService.getAllConfigurations());
        return "configurations";
    }
    @PostMapping("/new")
    public String saveConfiguration(Model model, @ModelAttribute("configuration") Configuration configuration) {
        model.addAttribute("configuration",configuration);
        model.addAttribute("configurations", configurationService.getAllConfigurations());
        return "configurations";
    }
    @GetMapping("/edit/{id}")
    public String editConfiguration(@PathVariable Long id, Model model) {
        model.addAttribute("configuration",configurationService.getConfigurationById(id));
        model.addAttribute("configurations", configurationService.getAllConfigurations());
        return "configurations";
    }
    @GetMapping("/delete/{id}")
    public String deleteConfiguration(Model model, @PathVariable Long id) {
        configurationService.deleteConfigurationById(id);
        return "configurations";
    }

}
