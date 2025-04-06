package com.devmaster.Lesson10.Controller;

import com.devmaster.Lesson10.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("messagesAdmin","Admin Dash Board");
        return "admin/index";
    }
}
