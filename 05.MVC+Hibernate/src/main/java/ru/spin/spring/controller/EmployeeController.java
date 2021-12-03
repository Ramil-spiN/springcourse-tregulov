package ru.spin.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spin.spring.entity.Department;
import ru.spin.spring.entity.Employee;
import ru.spin.spring.service.AppService;

import java.util.List;

@Controller
public class EmployeeController {
    private AppService<Employee> employeeService;
    private AppService<Department> departmentService;

    @Autowired
    public EmployeeController(AppService<Employee> employeeService, AppService<Department> departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        List<Department> departments = departmentService.getAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "employee-info";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//        Department dep = departmentService.getById(2);
//        employee.setDepartment(dep);
//        System.out.println(employee.getDepartment().getName());
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("id") int id, Model model) {
        Employee employee = employeeService.getById(id);
        List<Department> departments = departmentService.getAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "employee-info";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.delete(id);
        return "redirect:/";
    }
}
