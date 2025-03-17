package com.devmaster.Lesson7.controller;

import com.devmaster.Lesson7.entity.User;
import com.devmaster.Lesson7.repository.UserRepository;
import com.devmaster.Lesson7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String userList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User();
        user.setActive(true);
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult) {
        if(userService.existByUserName(user.getUserName()) && user.getId() == null) {
            bindingResult.rejectValue("userName", "error.user","Tài khoản đã tồn tại");
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user =
                userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy id"+ id));
        model.addAttribute("user", user);
        return "user/form";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
