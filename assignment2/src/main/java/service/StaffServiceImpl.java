package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.codeJava.BestDealsWeb.model.PdfStaffDetails;
import net.codeJava.BestDealsWeb.model.Staff;
import net.codeJava.BestDealsWeb.repository.StaffRepository;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public Staff findUserByNameStaff(String nameStaff) {
		return null;
	}

	@Override
	public Optional<Staff> find(String name) {
		System.out.println(staffRepository.findUserByNameStaff(name).get().getNameStaff());
		return staffRepository.findUserByNameStaff(name);
	}

	@Override
	public Staff login(String name, String password) {
		Optional<Staff> staff=this.find(name);
		if(staff!=null) {
			if(password.equals(staff.get().getPassword())) {
				System.out.println("login2");
				return staff.get();
			}
		}
		return null;	
	}

}
