package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.codeJava.BestDealsWeb.model.Staff;


public interface StaffService{
	Staff findUserByNameStaff(String nameStaff);
	public Optional<Staff> find(String name);
	public Staff login(String name, String password);

}
