package ru.spin.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @GetMapping("/")
    public String getAllEmployees() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username: " + auth.getName());
        System.out.println("username: " + auth.getAuthorities());
        return "employees";
    }

    @GetMapping("getHrInfo")
    public String getHrInfo() {
        return "hr-info";
    }

    @GetMapping("getManagerInfo")
    public String getManagerInfo() {
        return "manager-info";
    }
}
