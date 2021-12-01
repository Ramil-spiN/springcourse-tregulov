package ru.spin.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.spin.spring.models.Employee;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @RequestMapping("/")
    public String showHome(@ModelAttribute("employee") Employee employee) {
        return "home";
    }

    @RequestMapping("/askInfo")
    public String askEmployeeInfo(@ModelAttribute("employee") Employee employee) {
        return "ask-info";
    }

    /*@RequestMapping("/showInfo")
    public String showInfo(HttpServletRequest request, Model model) {
        employeeName = request.getParameter("employeeName");
        employeeName = employeeName + " (changed)";
        model.addAttribute("employeeName", employeeName);
        return "showinfo";
    }*/

    /*@RequestMapping("/showInfo")
    public String showInfo(@RequestParam("employeeName") String empName, Model model) {
        employeeName = "Mr. " + empName;
        model.addAttribute("employeeName", employeeName);
        return "show-info";
    }*/

    @RequestMapping("/showInfo")
    public String showInfo(@Valid @ModelAttribute("employee") Employee employee,
                           BindingResult bindingResult) {
        //BindingResult должен идти сразу после атрибута, который проверяем
        if (bindingResult.hasErrors()) {
            return "ask-info";
        } else {
            employee.setName("Mr. " + employee.getName());
            return "show-info";
        }
    }
}
