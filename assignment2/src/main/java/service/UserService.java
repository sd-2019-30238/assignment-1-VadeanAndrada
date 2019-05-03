package net.codeJava.BestDealsWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;



public interface UserService extends UserDetailsService {
	
	
	   User findUserByNameUser(String nameUser);

	   User save(User registration);

}
