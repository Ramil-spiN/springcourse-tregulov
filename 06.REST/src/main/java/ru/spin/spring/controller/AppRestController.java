package ru.spin.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spin.spring.entity.Employee;
import ru.spin.spring.exceptionhandling.EmployeeIncorrectData;
import ru.spin.spring.exceptionhandling.NoSuchEmployeeException;
import ru.spin.spring.service.AppService;

import java.util.List;

@RestController
@RequestMapping("api")
public class AppRestController {
    private AppService<Employee> employeeService;

    @Autowired
    public AppRestController(AppService<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("No such employee");
        }
        return employee;
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        //Spring и Jackson делают автоматическую конвертацию поступающего JSON-файла в объект класса Employee
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("No such employee to delete (id=" + id + ")");
        }
        employeeService.delete(id);
        return "Employee with id " + id + " was deleted";
    }

    //Отправка ошибок в JSON-формате
    //Переносим в класс с аннотацией @ControllerAdvice, предоставляющий функциональность
    // Global Exception Handler'а, работающий для всех контроллеров
//    @ExceptionHandler
//    public ResponseEntity<EmployeeIncorrectData> handleException (NoSuchEmployeeException exception) {
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//        data.setOtherInfo("Any information");
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<EmployeeIncorrectData> handleException (Exception exception) {
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//        data.setOtherInfo("Any information");
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }
}
