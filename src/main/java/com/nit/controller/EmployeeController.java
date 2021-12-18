package com.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nit.model.Employee;
import com.nit.service.EmployeeService;

@Controller
public class EmployeeController {

	private static final Logger logger = Logger
			.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeService employeeService;

	
	@RequestMapping(value = "/")
	public ModelAndView homepage(ModelAndView model) throws IOException {
		/*
		 * List<Employee> listEmployee = employeeService.getAllEmployees();
		 * model.addObject("listEmployee", listEmployee);
		 */
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/EmpDisplayReq")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("EmpDisplay");
		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}
	
	
	
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchpage(ModelAndView model) throws IOException {
		/*
		 * List<Employee> listEmployee = employeeService.getAllEmployees();
		 * model.addObject("listEmployee", listEmployee);
		 */
		model.setViewName("search");
		return model;
	}
	  
	@RequestMapping(value = "/searchEmp")
	@ResponseBody
	public ModelAndView search( @RequestParam("name") String name,@RequestParam("option") String option) {
	//	public ModelAndView search( String firstname) {
	System.out.println("search"+name);
	System.out.println(option);
	ModelAndView model = new ModelAndView("search");
	List<Employee> listEmployee = employeeService.search(name, option);
	System.out.println(listEmployee.get(0));
	model.addObject("listEmployee", listEmployee);
	model.setViewName("search");
		return model;
		
	}
	
	
	 
	 @RequestMapping(value = "/logout")
		public ModelAndView logout(ModelAndView model) throws IOException {
		
			model.setViewName("login");
			return model;
		}
	 
	 @RequestMapping(value = "/contact")
		public ModelAndView contact(ModelAndView model) throws IOException {
		
			model.setViewName("contact");
			return model;
		}
	 
	 @RequestMapping(value = "/aboutus")
		public ModelAndView aboutus(ModelAndView model) throws IOException {
		
			model.setViewName("AboutUs");
			return model;
		}
	 
	 @RequestMapping(value = "/home")
		public ModelAndView home(ModelAndView model) throws IOException {
		
			model.setViewName("home");
			return model;
		}
}