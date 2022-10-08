package com.example.spring.mark;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {

    @GetMapping("")
    public String run(Model model) {
        if (!AuthenticatedStudentInfo.isAuthenticated()) {
            return "index";
        }
        else {
            model.addAttribute("id", AuthenticatedStudentInfo.getAuthenticatedId());
            return "indexAll";
        }
    }
}
