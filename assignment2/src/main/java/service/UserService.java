package net.codeJava.BestDealsWeb.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import net.codeJava.BestDealsWeb.model.User;

public interface UserService extends UserDetailsService {

	   User findUserByNameUser(String nameUser);
	   User save(User registration);

}
