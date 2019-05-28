package net.codeJava.BestDealsWeb.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeJava.BestDealsWeb.dto.FurnitureQueryDto;
import net.codeJava.BestDealsWeb.dto.FurnitureSaveCommandDto;
import net.codeJava.BestDealsWeb.dto.UserRegisterCommandDto;
import net.codeJava.BestDealsWeb.handler.AddNewFurnitureHandler;
import net.codeJava.BestDealsWeb.handler.DeleteFurnitureHandler;
import net.codeJava.BestDealsWeb.handler.Handler;
import net.codeJava.BestDealsWeb.handler.SaveUserHandler;
import net.codeJava.BestDealsWeb.mediator.Mediator;
import net.codeJava.BestDealsWeb.mediator.MediatorImpl;
import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.FurnitureCommandService;


@Controller
@RequestMapping("/product")
public class FurnitureCommandController {

	@Autowired
	private  ApplicationContext applicationContext;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@ModelAttribute("product")
	public Furniture furniture() {
		return new Furniture();
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteFurniture(@PathVariable("id") int id) {
		
		Mediator mediator=new MediatorImpl();
		Handler handler=new DeleteFurnitureHandler();
		((DeleteFurnitureHandler)handler).setId(id);
		AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
		factory.autowireBean(handler);
		mediator.addHandler(handler);
		mediator.handle(handler.getCommand(), handler);
		return "redirect:../../homeStaff";
	}
	
	@PostMapping(value="/addFurniture")
	public String addFurniture(@ModelAttribute("product") @Valid FurnitureSaveCommandDto furnitureDto ) {
		Mediator mediator=new MediatorImpl();
		Handler handler=new AddNewFurnitureHandler();
		((AddNewFurnitureHandler)handler).setFurniture(convertToEntity(furnitureDto));
		AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
		factory.autowireBean(handler);
		mediator.addHandler(handler);
		mediator.handle(handler.getCommand(), handler);
		
		return "redirect:/homeStaff";
	}
	
	@GetMapping(value="/addFurniture")
	public String getAddFurniturePage() {
		
		return "addFurniture";
	}
	
	private Furniture convertToEntity(FurnitureSaveCommandDto furnitureDto) {
		return modelMapper.map(furnitureDto, Furniture.class);
	}

}
