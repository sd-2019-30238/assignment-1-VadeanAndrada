package net.codeJava.BestDealsWeb.handler;

import java.sql.SQLException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.codeJava.BestDealsWeb.dto.UserRegisterCommandDto;
import net.codeJava.BestDealsWeb.mediator.Mediator;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.UserCommandService;
import net.codeJava.BestDealsWeb.service.UserCommandServiceImpl;


@Component
public class SaveUserHandler implements Handler {

	@Autowired
	private UserCommandService userCommandService;

	User newUser;
	
	@Override
	public void execute(String command) {
		userCommandService.save(getNewUser());
	
	}
	
	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	} 

	@Override
	public String getCommand() {
		return "saveUser";
	}

	}
