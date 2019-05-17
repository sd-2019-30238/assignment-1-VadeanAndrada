package net.codeJava.BestDealsWeb.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.repository.OrderRepository;


@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> find(int id) {
		return orderRepository.findById(id);
	}

	@Override
	public Order update(Order order) {
		
		return orderRepository.save(order);
	}
	
}
