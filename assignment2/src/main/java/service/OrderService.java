package net.codeJava.BestDealsWeb.service;


import java.util.Optional;

import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.model.Order;

public interface OrderService {
	public void createOrder(Order order);
	public Iterable<Order> findAll();
	public Optional<Order> find (int id);
	public Order update(Order order);
}
