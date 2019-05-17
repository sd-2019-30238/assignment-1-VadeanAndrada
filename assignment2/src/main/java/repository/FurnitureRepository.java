package net.codeJava.BestDealsWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.codeJava.BestDealsWeb.model.Furniture;

@Repository
public interface FurnitureRepository extends CrudRepository<Furniture, Integer>{

}
