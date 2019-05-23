package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import net.codeJava.BestDealsWeb.model.Furniture;

@Component
public interface FurnitureService {
	
	public Iterable<Furniture> findAll();
	public Optional<Furniture> find (int id);
	public void delete(int id);
	public void add(Furniture f); 

}
