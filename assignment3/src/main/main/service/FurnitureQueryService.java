package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import net.codeJava.BestDealsWeb.model.Furniture;

public interface FurnitureQueryService {
	public Iterable<Furniture> findAll();
	public Optional<Furniture> find (int id);
}
