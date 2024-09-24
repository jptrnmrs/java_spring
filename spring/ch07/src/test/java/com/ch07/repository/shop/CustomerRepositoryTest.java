package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    @Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }

    @Test
    public void selectsCustomer(){
        List<Customer> customers1 = customerRepository.selectCustomer("김유신",0);
        List<Customer> customers2 = customerRepository.selectCustomer("김유신",30);
        List<Customer> customers3 = customerRepository.selectCustomer("강감찬",0);
        List<Customer> customers4 = customerRepository.selectCustomer("강감찬",40);

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);
        System.out.println(customers4);
    }

    @Test
    public void selectProjectionCustomer(){
        List<Customer> customers = customerRepository.selectProjectionCustomer();
        System.out.println(customers);
    }

    @Test
    public void searchKeyword(){
        List<Customer> customers1 = customerRepository.searchKeyword("유신");
        List<Customer> customers2 = customerRepository.searchKeyword("경주");
        System.out.println(customers1);
        System.out.println(customers2);
    }
}
