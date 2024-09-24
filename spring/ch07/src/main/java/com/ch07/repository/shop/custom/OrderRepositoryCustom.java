package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    public List<Order> selectOrders();
    public Order selectOrder(String orderCustomer);
    public List<Order> selectProjectionOrder();

    public List<Order> selectOrder(String customerCondition, int statusCondition);
    public List<Order> searchKeyword(String keyword);
}
