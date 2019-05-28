package net.codeJava.BestDealsWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeJava.BestDealsWeb.service.FurnitureQueryService;


@Controller
@RequestMapping("/product")
public class FunritureQueryController {
	@Autowired
	private FurnitureQueryService furnitureQueryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String homeUser(ModelMap modelMap) {
		
		modelMap.put("products", furnitureQueryService.findAll());
		return "homeUser";
	}
	
}
