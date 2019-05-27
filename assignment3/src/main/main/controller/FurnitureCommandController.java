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
import net.codeJava.BestDealsWeb.service.FurnitureCommandService;
import net.codeJava.BestDealsWeb.service.FurnitureService;

@Controller
@RequestMapping("/product")
public class FurnitureCommandController {

	@Autowired
	private FurnitureCommandService furnitureService;
	
	@ModelAttribute("product")
	public Furniture furniture() {
		return new Furniture();
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteFurniture(@PathVariable("id") int id) {
		
		furnitureService.delete(id);
		return "redirect:../../homeStaff";
	}
	
	@PostMapping(value="/addFurniture")
	public String addFurniture(@ModelAttribute("product") @Valid Furniture f ) {
		furnitureService.add(f);
		return "redirect:/homeStaff";
	}
	
	@GetMapping(value="/addFurniture")
	public String getAddFurniturePage() {
		
		return "addFurniture";
	}
}
