package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import net.codeJava.BestDealsWeb.model.Order;

public interface OrderQueryService {
	public Iterable<Order> findAll();
	public Optional<Order> find (int id);
}
