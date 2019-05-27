package net.codeJava.BestDealsWeb.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;
import net.codeJava.BestDealsWeb.service.FurnitureService;
import net.codeJava.BestDealsWeb.service.OrderService;

@Controller
@RequestMapping("/cart")
public class CartCommandController {

	@Autowired
	private FurnitureService furnitureService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute("user")
	public User user() {
		
		return new User();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String cart(ModelMap modelMap,HttpSession session) {
		
		modelMap.put("total", total(session));
		return "cart";

	}

	@RequestMapping(value="/checkOut", method = RequestMethod.GET)
	public String checkOut(HttpSession session) {
		
		if(session.getAttribute("userr")==null) 
			return "redirect:../loginShow";

		Order order=new Order();
		User user = userRepository.findUserByNameUser(session.getAttribute("userr").toString()).get();
		order.setUsername(user.getNameUser());
		order.setDelivered(0);
		order.setTotalPrice(total(session)+"");
		orderService.createOrder(order);
		session.removeAttribute("cart");

		return "thanks";
	}


	@RequestMapping(value= "/buy/{id}",method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id,
			ModelMap modelMap,
			HttpSession session) {
		
		if(session.getAttribute("cart")==null) {
			ArrayList<Furniture> cart=new ArrayList<Furniture>();
			cart.add(furnitureService.find(id).orElse(null));
			session.setAttribute("cart", cart);	
		}
		else
		{
			ArrayList<Furniture> cart=(ArrayList<Furniture>) session.getAttribute("cart");
			cart.add(furnitureService.find(id).orElse(null));
			session.setAttribute("cart", cart);	
		}
		
		return "redirect:../../cart";
	}


	@RequestMapping(value= "/remove/{id}",method = RequestMethod.GET)
	public String remove(@PathVariable("id") int id,
			ModelMap modelMap,
			HttpSession session) {

		ArrayList<Furniture> cart=(ArrayList<Furniture>) session.getAttribute("cart");
		int indexProduct=productExists(id,cart);
		cart.remove(indexProduct);
		session.setAttribute("cart", cart);	

		return "redirect:../../cart";
	}
	
	private int productExists(int id, ArrayList<Furniture> cart) {
		for(Furniture product: cart) {
			if(product.getId()==id)
				return cart.indexOf(product);
		}
		return -1;
	}
	
	private double total(HttpSession session) {
		ArrayList<Furniture> cart=(ArrayList<Furniture>) session.getAttribute("cart");
		double totalOrder=0;
		for(Furniture product: cart) {
			totalOrder+=Double.parseDouble(product.getPrice());
		}
		return totalOrder;	
	}
	
}

