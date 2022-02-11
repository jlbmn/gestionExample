package fr.formation.inti.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.validator.ValidatorEmployee;

@Controller
public class EmployeeController {
	
	private Log log = LogFactory.getLog(EmployeeController.class);
	
	@Autowired
	private ValidatorEmployee employeeValidator;

	@InitBinder   
	public void initBinder(WebDataBinder binder) {  
		Object target = binder.getTarget();
		if(target == null) {
			return;
		}
		if(target.getClass() == Employee.class) {
			binder.setValidator(employeeValidator);
		}

	}

	@RequestMapping(value = "/employeeForm", method = RequestMethod.GET)
	public String index(@ModelAttribute("employee") Employee emp) {			
		log.info("-----------------------");
		log.info("-----------------------> GET MAPPING");

		return "employeeForm";
	}
	
	@RequestMapping(value = "/employeeForm", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("employee") Employee emp, BindingResult result) {
		log.info("-----------------------");
		log.info("-----------------------> POST MAPPING");
		log.info("Employee -----------------------> " +emp);
		log.info("Has Error ? -----------------------> " + result.hasErrors());
		
		if (result.hasErrors()) {
			return "employeeForm";
		}
		
		return "success";
	}
}
