package fr.formation.inti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// pour dire que cest un bean gere par spring
@Controller
public class IndexController {
	// les methodes retournent des String
	// comme le nom de la page 
	
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("message", "Hello Spring MVC");
		return "login";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String login(Model model) {
		model.addAttribute("message", "Hello Spring MVC");
		return "home";
	}
	
}
