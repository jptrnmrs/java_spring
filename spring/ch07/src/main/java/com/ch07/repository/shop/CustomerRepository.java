package com.ch07.repository.shop;

import com.ch07.entity.board.User;
import com.ch07.entity.shop.Customer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, CustomerRepositoryCustom {
}
