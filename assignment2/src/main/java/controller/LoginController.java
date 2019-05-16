package net.codeJava.BestDealsWeb.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import net.codeJava.BestDealsWeb.model.PdfUserDetails;
import net.codeJava.BestDealsWeb.model.Staff;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.FurnitureService;
import net.codeJava.BestDealsWeb.service.StaffService;
import net.codeJava.BestDealsWeb.service.UserService;


@Controller
public class LoginController {

	@ModelAttribute("user")
	public User user() {
		return new User();
	}
	@ModelAttribute("staff")
	public Staff staff() {
		return new Staff();
	}
	@Autowired
	private UserService userService;
	
	@Autowired
	private FurnitureService furnitureService;
	
	@Autowired
	private StaffService staffService;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String homeUser(ModelMap modelMap) {
		modelMap.put("products", furnitureService.findAll());
		return "homeUser";
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login() {
	        return "login";
	    }
	
	@GetMapping("/loginStaff")
		public String loginStaff() {
			return "loginStaff";
		}
	
	@GetMapping("/loginStaf")
	public String loginStaff2(Model model) {
		return "loginStaff";
	}
	@PostMapping("/loginStaf")
	public String postLoginStaff(
			HttpServletRequest request,
			ModelMap modelMap,
			@ModelAttribute("staff") Staff staff) {
		String username=staff.getNameStaff();
		String password=staff.getPassword();
		Staff staff1=staffService.login(username, password);
		if(staff1==null) {
			modelMap.put("error", "Invalid account");
			return "loginStaff";
		}
		
		return "homeStaff";
	}
	
	@RequestMapping(value ="/staff",method = RequestMethod.POST)
	public String homeStaff() {
		return "homeStaff";
	}
		
	
	@RequestMapping(value ="/staffPage",method = RequestMethod.POST)
	public String homeStaffPage(ModelMap modelMap) {
		modelMap.put("products", furnitureService.findAll());
		return "homeStaff";
	}
	
	
	 @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	    public String postLogin(Model model, HttpSession session,ModelMap modelMap) {
		 
	        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
	        validatePrinciple(authentication.getPrincipal());
	        User loggedInUser = ((PdfUserDetails) authentication.getPrincipal()).getUserDetails();
	        model.addAttribute("currentUser", loggedInUser.getNameUser());
	    	modelMap.put("products", furnitureService.findAll());    
	        session.setAttribute("userr",  loggedInUser.getNameUser());
	        
	        return "homeUser";
	    }

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
	
	private void validatePrinciple(Object principal) {
        if (!(principal instanceof PdfUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }
}
