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
public class UserQueryServiceImpl implements UserQueryService{

	@Autowired
    private UserRepository userRepository;

	
	 @Transactional(readOnly = true)
	 @Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findUserByNameUser(arg0).get();
		return new PdfUserDetails(user);
	}
}
