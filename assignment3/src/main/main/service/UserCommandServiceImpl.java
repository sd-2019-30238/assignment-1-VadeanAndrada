package net.codeJava.BestDealsWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;


@Service
public class UserCommandServiceImpl implements UserCommandService {
	
	@Autowired
    private UserRepository userRepository;
	

	 public UserCommandServiceImpl() {}

	@Override
	public void save(User registration){
        User user = new User();
        user.setNameUser(registration.getNameUser());
        user.setEmail(registration.getEmail());
        user.setPassword(registration.getPassword());
        user.setAddress(registration.getAddress());
        user.setPhoneUser(registration.getPhoneUser());
        userRepository.save(user);
    }

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
}
