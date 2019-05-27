package net.codeJava.BestDealsWeb.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import net.codeJava.BestDealsWeb.service.UserService;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserService userService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/loginShow","/createAccount").permitAll()
		.antMatchers("/loginShow","/loginShowUser").permitAll()
		.antMatchers("/loginShow","/loginStaff").permitAll()
		.antMatchers("/createAccountUser").permitAll()
		.antMatchers("/sendEmail").permitAll()
		.antMatchers("/loginStaf").permitAll()
		.antMatchers( "/orders").permitAll()
		.antMatchers("/showOrders").permitAll()
		.antMatchers( "/product").permitAll()
		.antMatchers("/homeStaff").permitAll()
		.antMatchers(HttpMethod.PUT,
                  "/orders/edit/id").permitAll()
		.antMatchers(HttpMethod.POST,
                "/loginStaff/homeStaff/product/addFurniture").permitAll()
		.antMatchers(HttpMethod.DELETE,
                "/loginStaff/homeStaff/product/delete/id").permitAll()
		.antMatchers(HttpMethod.PUT,
                  "/orders").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
		.loginProcessingUrl("/doLogin")
		.successForwardUrl("/postLogin")
		.permitAll()
		.and()
		.logout();
	}
	
	@Bean
	public AuthenticationProvider getProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(getEncoder());
		return provider;
	}
	
	@Bean
	public PasswordEncoder getEncoder() {
		return new PasswordEncoder() {	
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.toString().equals(encodedPassword);
			}
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	

}
