package net.codeJava.BestDealsWeb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.codeJava.BestDealsWeb.dto.StaffLoginQueryDto;
import net.codeJava.BestDealsWeb.model.Staff;
import net.codeJava.BestDealsWeb.service.FurnitureQueryService;
import net.codeJava.BestDealsWeb.service.FurnitureService;
import net.codeJava.BestDealsWeb.service.StaffQueryService;

@Controller
public class StaffQueryController {

	
	@Autowired
	private StaffQueryService staffQueryService;
	
	@Autowired
	private FurnitureQueryService furnitureQueryService;
	
	@ModelAttribute("staff")
	public StaffLoginQueryDto staffDto() {
		return new StaffLoginQueryDto();
	}
	
	@GetMapping("/loginStaff")
	public String loginStaff2(ModelMap modelMap) {
		return "loginStaff";
	}
	
	
	@PostMapping("/loginStaff")
	public String postLoginStaff(
			HttpServletRequest request,
			ModelMap modelMap,
			@ModelAttribute("staff") StaffLoginQueryDto staffDto) {
		String username=staffDto.getNameStaff();
		String password=staffDto.getPassword();
		Staff staff1=staffQueryService.login(username, password);
		if(staff1==null) {
			modelMap.put("error", "Invalid account");	
			return "loginStaff";
		}
		return "redirect:homeStaff";
	}
	
	@GetMapping("/homeStaff")
	public String getHomeStaff(ModelMap modelMap) {
		modelMap.put("products", furnitureQueryService.findAll());   
		return "homeStaff";
	}
	
	@PostMapping("/homeStaff")
	public String homeStaff(ModelMap modelMap) {
		return "homeStaff";
		
	}
	
}
