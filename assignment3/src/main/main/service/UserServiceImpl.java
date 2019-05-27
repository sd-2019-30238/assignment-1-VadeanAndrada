package net.codeJava.BestDealsWeb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codeJava.BestDealsWeb.model.PdfUserDetails;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
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
	
	
	 @Transactional(readOnly = true)
	 @Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findUserByNameUser(arg0).get();
		return new PdfUserDetails(user);
	}

	@Override
	public User findUserByNameUser(String nameUser) {
		return null;
	}

}
