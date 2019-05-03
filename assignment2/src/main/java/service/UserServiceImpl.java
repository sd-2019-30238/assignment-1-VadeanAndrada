package net.codeJava.BestDealsWeb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
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
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findUserByNameUser(arg0).get();
		return new UserDetails() {	
			@Override
			public boolean isEnabled() {

				return true;
			}		
			@Override
			public boolean isCredentialsNonExpired() {

				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {

				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {

				return true;
			}
			
			@Override
			public String getUsername() {

				return user.getNameUser();
			}
			
			@Override
			public String getPassword() {
	
				return user.getPassword();
			}

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {

				return null;
			}
		};
	}

	@Override
	public User findUserByNameUser(String nameUser) {
		return null;
	}

}
