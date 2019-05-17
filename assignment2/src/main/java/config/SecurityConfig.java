package net.codeJava.BestDealsWeb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import net.codeJava.BestDealsWeb.service.UserService;


//@Configuration
//@EnableWebSecurity


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
		  .antMatchers(
                  "/createAccountUser",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
		  .antMatchers(
                  "/loginStaf",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
		  .antMatchers(
                  "/orders",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
		  .antMatchers(
                  "/showOrders",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
		  .antMatchers(
                  "/product",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
		  .antMatchers(
                  "/homeStaff",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
		  .antMatchers(
                  "/cart",
                  "/js/**",
                  "/css/**",
                  "/img/**",
                  "/webjars/**").permitAll()
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

}
