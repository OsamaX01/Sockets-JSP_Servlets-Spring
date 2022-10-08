package com.example.spring.mark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    DataBaseService databaseService;

    @Autowired
    public LoginController(DataBaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        if (AuthenticatedStudentInfo.isAuthenticated()) {
            return "loggedIn";
        }

        model.addAttribute("student", new Student());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Student student) {
        if (!databaseService.isValidStudent(student.getId())) {
            return "invalidCredentials";
        }
        if (!databaseService.isValidPassword(student.getId(), student.getPassword())) {
            return "invalidCredentials";
        }
        AuthenticatedStudentInfo.setIsAuthenticated(true);
        AuthenticatedStudentInfo.setAuthenticatedId(student.getId());
        return "loggedIn";
    }
}
