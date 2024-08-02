package test10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingMall {
	private List<Customer> customers;
	private List<Order> orders;
	private Map<String,List<Order>> customerOrders;
	public ShoppingMall() {
		customers = new ArrayList<>();
		orders = new ArrayList<>();
		customerOrders = new HashMap();
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public List<Order> getOrders() {
		return orders;
	}
}
