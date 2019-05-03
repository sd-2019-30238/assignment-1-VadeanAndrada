package net.codeJava.BestDealsWeb.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.codeJava.BestDealsWeb.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	Optional<User> findUserByNameUser(String nameUser);
}
