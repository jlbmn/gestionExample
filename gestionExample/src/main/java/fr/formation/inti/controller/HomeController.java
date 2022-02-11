package fr.formation.inti.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.IUserService;

@Controller
public class HomeController {
	
//	@Autowired
//	private IEmployeeService employeeService;
//	
	@Autowired
	private IUserService userService;
	
	private Log log = LogFactory.getLog(HomeController.class);
	
	/** 
	 * Retourne un String avec nom de la vue (page jsp)
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("message", "Application Spring MVC méthode >>> GET <<< ");
		model.addAttribute("user", new User("root1", "123456", 3));
		// RENVOIE vers la page home.jsp
		return "home";
				
	}
	
//	@RequestMapping(value = "/home", method = RequestMethod.POST)
//	public String homePost(Model model, @RequestParam("firstName") String name) {
//		model.addAttribute("message", "Application Spring MVC méthode >>> POST <<< " +name);
//		model.addAttribute("user", new User("root1", "123456", 3));
//		// RENVOIE vers la page home.jsp
//		return "home";
//		
//	}
	
//	@RequestMapping(value = "/home", method = RequestMethod.POST)
//	public String home2(Model model,
//			@RequestParam("firstName") String nom ,
//			@RequestParam("id") Integer id ) {
//		model.addAttribute("message","Application SPRING MVC method post :"+nom +" "+id);
//		if(id != null) {
//			Employee emp = service.findById(id);
//			model.addAttribute("message",emp);
//		}
//		return "home";
//	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home2(Model model,
			@RequestParam("login") String login ,
			@RequestParam("password") String password ) {
//		log.debug("home2 post");
		log.info(login);
		log.info(password);
		
		User u = userService.findByLoginAndPassword(login, password);
		model.addAttribute("message", "home 2 , Hello : "+u);
		model.addAttribute("emp" , u.getEmp());
		
		return "home";
	}
	
	
//	 // NE FONCTIONNE PAS LES DEUX METHODES LA
//	@GetMapping("/home")
//	public String showForm(Model model) {
//		User user = new User();
//        model.addAttribute("user", user);
//		return "login";
//	}
//
//	@PostMapping("/home")
//	public String checkSubmitForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
//		
//		if (bindingResult.hasErrors()) {
//			return "login";
//		}
//
//		return "redirect:/home";
//	}
	
	
	/** 
	 * retourne un objet de type modelandview
	 * il faut lui setter le nom de la vue
	 * @return
	 */
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public ModelAndView home() {
		// instanciation de ModelAndView
		ModelAndView mv = new ModelAndView(); 
		// chargement de mv avec un objet
		mv.addObject(new User("root2", "123456", 3)); 
		// set un nom a la vue 
		// RENVOIE vers la page home.jsp
		mv.setViewName("home");
		return mv;
	}
	
}


