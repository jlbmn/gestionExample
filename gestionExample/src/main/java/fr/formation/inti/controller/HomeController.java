package fr.formation.inti.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.validator.ValidatorEmployee;
import fr.formation.inti.validator.ValidatorUser;

@Controller
public class HomeController {
		
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ValidatorUser userValidator;
	
	private Log log = LogFactory.getLog(HomeController.class);
	
	@InitBinder   
	public void initBinder(WebDataBinder binder) {  
		Object target = binder.getTarget();
		if(target == null) {
			return;
		}
		if(target.getClass() == User.class) {
			binder.setValidator(userValidator);
		}
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(@ModelAttribute("user") User user) {	
			return "login";	
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String register(Model model, @Validated @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		}
		user = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
		model.addAttribute("emp", user.getEmp());
		return "home";
		

	}	

	
	
}


