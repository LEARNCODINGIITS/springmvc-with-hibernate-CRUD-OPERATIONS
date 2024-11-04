package com.iits.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iits.dao.EmployeeDAO;
import com.iits.entity.Employee;
 @Controller
public class HelloController{
	 
	 @Autowired
	 private EmployeeDAO employeeDAO;
	 
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		mv.addObject("msg", "WELCOME TO HOME PAGE");
		
		return mv;
	}
	
	@RequestMapping(value="/createEmployeeForm",method=RequestMethod.GET)
	public String createEmployeeForm(Model model) {
		model.addAttribute("emp", new Employee());
		return "employeeform";
	}
 
	@RequestMapping(value="/storeEmployee",method=RequestMethod.POST)
	public String storeEmployee(@ModelAttribute Employee employee,Model model) {
		System.out.println(employee+"<----------");
		if(employee!=null) {
			this.employeeDAO.saveEmployee(employee);
			model.addAttribute("msg","SUCCESSFULLY STORE IN DB..");
			return "success";
			
		}else {
			return "failure";
		}
	}
	
	@RequestMapping(value="/employees/updateForm",method=RequestMethod.POST)
	public String updateForm(@ModelAttribute Employee employee) {
		System.out.println(employee+"<----------");
		if(employee!=null) {
			this.employeeDAO.updateEmployee(employee);
			return "redirect:/employees";
			
		}else {
			return "failure";
		}
	}
	 @RequestMapping(value="/employees",method=RequestMethod.GET)
	public String displayAllEmployees(Model model) {
		 List<Employee> list=this.employeeDAO.getAllEmployees();
		 model.addAttribute("list", list);
		return "display";
		
	}
	 
	 @RequestMapping(value="/employees/delete/{eid}",method=RequestMethod.GET)
	 public String deleteById(@PathVariable("eid") int eid) {
		 this.employeeDAO.deleteById(eid);
		 return "redirect:/employees";
	 }
	 
	 @RequestMapping(value="/employees/update/{eid}",method=RequestMethod.GET)
	 public String update(@PathVariable("eid") int eid, Model model) {
		 System.out.println("inside the update method..");
		  Employee employee =this.employeeDAO.getEmployee(eid);
		  System.out.println("Employee:"+employee+" by id");
		  model.addAttribute("emp", employee);
		 return "employeeform1";
	 }
}
