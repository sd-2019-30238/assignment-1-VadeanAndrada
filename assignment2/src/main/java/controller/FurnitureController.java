package net.codeJava.BestDealsWeb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.service.FurnitureService;

@Controller
@RequestMapping("/product")
public class FurnitureController {

	@Autowired
	private FurnitureService furnitureService;
	
	@ModelAttribute("product")
	public Furniture furniture() {
		return new Furniture();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String homeUser(ModelMap modelMap) {
		
		modelMap.put("products", furnitureService.findAll());
		return "homeUser";
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteFurniture(@PathVariable("id") int id) {
		
		furnitureService.delete(id);
		return "redirect:../../homeUser";
	}
	
	@PostMapping(value="/addFurniture")
	public String addFurniture(@ModelAttribute("product") @Valid Furniture f ) {
		furnitureService.add(f);
		return "homeStaff";
	}
	
	@GetMapping(value="/addFurniture")
	public String getAddFurniturePage() {
		
		return "addFurniture";
	}
}
