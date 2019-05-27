package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import net.codeJava.BestDealsWeb.model.Staff;


public interface StaffQueryService{
	Staff findUserByNameStaff(String nameStaff);
	public Optional<Staff> find(String name);
	public Staff login(String name, String password);

}
