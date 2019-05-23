package net.codeJava.BestDealsWeb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.codeJava.BestDealsWeb.model.Staff;
import net.codeJava.BestDealsWeb.service.FurnitureService;
import net.codeJava.BestDealsWeb.service.StaffService;

@Controller
public class StaffController {

	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private FurnitureService furnitureService;
	
	@ModelAttribute("staff")
	public Staff staff() {
		return new Staff();
	}
	
	@GetMapping("/loginStaff")
	public String loginStaff2(ModelMap modelMap) {
		return "loginStaff";
	}
	
	
	@PostMapping("/loginStaff")
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
		return "redirect:homeStaff";
	}
	
	@GetMapping("/homeStaff")
	public String getHomeStaff(ModelMap modelMap) {
		modelMap.put("products", furnitureService.findAll());   
		return "homeStaff";
	}
	
	@PostMapping("/homeStaff")
	public String homeStaff(ModelMap modelMap) {
		return "homeStaff";
		
	}
	
}
