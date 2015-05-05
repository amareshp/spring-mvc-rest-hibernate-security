package com.visitamaresh.ws.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.visitamaresh.ws.component.EmployeeService;
import com.visitamaresh.ws.component.HtmlPageService;
import com.visitamaresh.ws.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private HtmlPageService pageService;
    
    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = { "/list/", "/list" }, method = RequestMethod.GET)
    public String listEmployees(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        String ssn = allRequestParams.get("ssn");
        System.out.println("ssn: " + ssn);
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        List<Employee> employees = new ArrayList<Employee>();
        if( ssn == null || (ssn.length() == 0) ) {
            employees = service.findAllEmployees();
        } else {
            Employee emp = service.findBySsn(ssn);
            employees.add(emp);
        }
        model.addAttribute("empList", employees);
        return "employees";
    }
    
}