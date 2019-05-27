package net.codeJava.BestDealsWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;


@Service
public class UserCommandServiceImpl implements UserCommandService {
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public User save(User registration){
        User user = new User();
        user.setNameUser(registration.getNameUser());
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());
        user.setAddress(registration.getAddress());
        user.setPhoneUser(registration.getPhoneUser());
        return userRepository.save(user);
    }
	
	
}
