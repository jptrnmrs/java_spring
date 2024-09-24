package com.ch07.repository.shop.custom;

import com.ch07.entity.shop.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    public List<Customer> selectCustomers();
    public Customer selectCustomer(String custId);
    public List<Customer> selectProjectionCustomer();

    public List<Customer> selectCustomer(String nameCondition, int ageCondition);
    public List<Customer> searchKeyword(String keyword);
}
