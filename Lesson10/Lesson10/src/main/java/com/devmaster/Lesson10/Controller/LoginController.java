package com.devmaster.Lesson10.Controller;

import com.devmaster.Lesson10.Entity.User;
import com.devmaster.Lesson10.Repository.UserRepository;
import com.devmaster.Lesson10.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String login(@RequestParam(value = "error",required=false) String error, HttpServletRequest request, Model model) {
        if (error != null) {
            String errMsg = (String) request.getSession().getAttribute("LoginError");
            model.addAttribute("LoginError", errMsg);
        }
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(Model model,User user) {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (existingUser != null) {
            model.addAttribute("messageExistingUser", "Tên đăng nhập đã tồn tại");
        return "register";
        }
        User newUser = new User();
        newUser.setFullName(user.getFullName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return "redirect:/login";
    }
}
