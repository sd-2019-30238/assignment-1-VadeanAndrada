 package net.codeJava.BestDealsWeb.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.codeJava.BestDealsWeb.dto.UserRegisterCommandDto;
import net.codeJava.BestDealsWeb.handler.Handler;
import net.codeJava.BestDealsWeb.handler.SaveUserHandler;
import net.codeJava.BestDealsWeb.mediator.Mediator;
import net.codeJava.BestDealsWeb.mediator.MediatorImpl;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.FurnitureQueryService;
import net.codeJava.BestDealsWeb.service.UserCommandService;

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

	@Autowired
	private  ApplicationContext applicationContext;


	@PostMapping("/createAccountUser")
	public String registerUserAccount(@ModelAttribute("user") @Valid UserRegisterCommandDto userDto){
		Mediator mediator=new MediatorImpl();
		Handler handler=new SaveUserHandler();
		((SaveUserHandler)handler).setNewUser(convertToEntity(userDto));
		AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
		factory.autowireBean(handler);
		mediator.addHandler(handler);
		mediator.handle(handler.getCommand(), handler);

		return "login";
	
	}
	
	private User convertToEntity(UserRegisterCommandDto userDto) {
		return modelMapper.map(userDto, User.class);
	}


	
}
