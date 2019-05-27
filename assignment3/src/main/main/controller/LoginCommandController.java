 package net.codeJava.BestDealsWeb.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.codeJava.BestDealsWeb.dto.UserRegisterCommandDto;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.FurnitureQueryService;
import net.codeJava.BestDealsWeb.service.UserCommandService;
import net.codeJava.BestDealsWeb.service.UserService;

@Controller
public class LoginCommandController {
	@ModelAttribute("user")
	public UserRegisterCommandDto userDto() {
		return new UserRegisterCommandDto();
	}
	
	@Autowired
	private UserCommandService userCommandService;
	
	@Autowired
    private ModelMapper modelMapper;



	@PostMapping("/createAccountUser")
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegisterCommandDto userDto){

		userCommandService.save(convertToEntity(userDto));
		return "login";
	}
	
	private User convertToEntity(UserRegisterCommandDto userDto) {
		return modelMapper.map(userDto, User.class);
	}
	
}
