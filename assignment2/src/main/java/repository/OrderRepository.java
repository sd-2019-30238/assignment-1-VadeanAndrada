package net.codeJava.BestDealsWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.codeJava.BestDealsWeb.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}
