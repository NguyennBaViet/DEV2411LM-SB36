package com.devmaster.Lesson10.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("messagesHome", "Hello World");
        return "home";
    }
}
