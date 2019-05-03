package net.codeJava.BestDealsWeb.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.UserService;

@Controller
public class LoginController {

	@ModelAttribute("user")
	public User user() {
		return new User();
	}
	@Autowired
	private UserService userService;

	@RequestMapping(value="/loginShow", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

//	@GetMapping("/product")
//	public String home() {
//		return "homeUser";
//	}

	@GetMapping("/createAccount")
	public String createAccount() {
		return "createAccountUser";
	}


	@GetMapping("/createAccountUser")
	public String showRegistrationForm(Model model) {
		return "createAccountUser";
	}

	@PostMapping("/createAccountUser")
	public String registerUserAccount(@ModelAttribute("user") @Valid User user){

		//	        User existing = userService.findByEmail(userDto.getEmail());
		//	        if (existing != null){
		//	            result.rejectValue("email", null, "There is already an account registered with that email");
		//	        }
		//
		//	        if (result.hasErrors()){
		//	            return "registration";
		//	        }

		userService.save(user);
		return "homeUser";
	}


}
