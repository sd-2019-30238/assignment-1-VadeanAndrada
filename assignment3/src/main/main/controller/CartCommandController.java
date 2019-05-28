package net.codeJava.BestDealsWeb.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeJava.BestDealsWeb.decorator.DiscountDecorator;
import net.codeJava.BestDealsWeb.decorator.ShopCart;
import net.codeJava.BestDealsWeb.decorator.ShopCartImpl;
import net.codeJava.BestDealsWeb.dto.CreateNewOrderCommandDto;
import net.codeJava.BestDealsWeb.dto.UserRegisterCommandDto;
import net.codeJava.BestDealsWeb.handler.CreateOrderHandler;
import net.codeJava.BestDealsWeb.handler.Handler;
import net.codeJava.BestDealsWeb.mediator.Mediator;
import net.codeJava.BestDealsWeb.mediator.MediatorImpl;
import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;
import net.codeJava.BestDealsWeb.service.FurnitureQueryService;
import net.codeJava.BestDealsWeb.service.OrderCommandService;

@Controller
@RequestMapping("/cart")
public class CartCommandController {

	@Autowired
	private FurnitureQueryService furnitureService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private ModelMapper modelMapper;
	@ModelAttribute("user")
	public User user() {
		
		return new User();
	}
	
	@Autowired
	private  ApplicationContext applicationContext;

	@RequestMapping(method = RequestMethod.GET)
	public String cart(ModelMap modelMap,HttpSession session) {
		
		modelMap.put("total", total(session));
		return "cart";

	}

	@RequestMapping(value="/checkOut", method = RequestMethod.GET)
	public String checkOut(HttpSession session) {
		
		if(session.getAttribute("userr")==null) 
			return "redirect:../loginShow";

		CreateNewOrderCommandDto orderDto=getOrder(session);
		Mediator mediator=new MediatorImpl();
		Handler handler=new CreateOrderHandler();
		((CreateOrderHandler)handler).setOrder(convertToEntity(orderDto));
		AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
		factory.autowireBean(handler);
		mediator.addHandler(handler);
		mediator.handle(handler.getCommand(), handler);
		
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
		
		ShopCart shopCart=new ShopCartImpl();
		shopCart.setPrice((float)totalOrder);
		ShopCart decoratedShopCart=new DiscountDecorator(shopCart);
		return decoratedShopCart.getTotalPrice();	
	}
	
	public CreateNewOrderCommandDto getOrder(HttpSession session) {
		CreateNewOrderCommandDto orderDto=new CreateNewOrderCommandDto();
		User user = userRepository.findUserByNameUser(session.getAttribute("userr").toString()).get();
		orderDto.setUsername(user.getNameUser());
		orderDto.setDelivered(0);
		orderDto.setTotalPrice(total(session)+"");
		return orderDto;
	}
	
	private Order convertToEntity(CreateNewOrderCommandDto orderDto) {
		return modelMapper.map(orderDto, Order.class);
	}
}

