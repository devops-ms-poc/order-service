package com.order;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/order")
public class OrdersController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private OrdersRepository ordersRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Orders> GetOrders() {
		return ordersRepository.findAll();
	}

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addOrder() {

		Orders orders = new Orders();
		Random random = new Random();
		orders.setCartId(random.nextInt());
		orders.setCustId(random.nextInt());
		orders.setOrderId(random.nextInt());
		// Timestamp timestamp = null;
		// orders.setDateCreated(timestamp);
		orders.setDateCreated("date");
		orders.setStatus("status");
		orders.setPaymentMode("paymentmode");
		ordersRepository.save(orders);
		return "Saved";
	}

}