package net.codeJava.BestDealsWeb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.codeJava.BestDealsWeb.model.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer> {
	Optional<Staff> findUserByNameStaff(String nameStaff);
}
