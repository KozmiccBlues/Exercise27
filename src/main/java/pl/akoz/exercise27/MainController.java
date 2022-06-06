package pl.akoz.exercise27;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akoz.exercise27.employee.Employee;
import pl.akoz.exercise27.employee.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    private final EmployeeRepository employeeRepository;

    public MainController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employeeRepository.findAll());

        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Employee> add = employeeRepository.findAll();
        model.addAttribute("employeeToAdd", new Employee());
        return "add";
    }

    @PostMapping("/add")
    public String add(Employee employee) {
        employeeRepository.save(employee);

        return "redirect:/";
    }
}
