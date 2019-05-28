package net.codeJava.BestDealsWeb.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeJava.BestDealsWeb.service.OrderQueryService;

@Controller
@Transactional
@RequestMapping("/orders")
public class OrderQueryController {

	@Autowired
	OrderQueryService orderQueryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAllOrders(ModelMap modelMap) {
		modelMap.put("orders", orderQueryService.findAll());   
		return "orders";
	}
}
