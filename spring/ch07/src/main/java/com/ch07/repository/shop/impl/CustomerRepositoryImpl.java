package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.CustomerRepository;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QCustomer qCustomer = QCustomer.customer;

    @Override
    public List<Customer> selectCustomers() {
        return queryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomer(String custId) {
        return queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> selectProjectionCustomer() {
        return queryFactory
                .select(
                        Projections.fields(
                                Customer.class,
                                qCustomer.custId,
                                qCustomer.name,
                                qCustomer.age
                        )
                )
                .from(qCustomer)
                .fetch();
    }

    @Override
    public List<Customer> selectCustomer(String nameCondition, int ageCondition) {

        BooleanBuilder builder = new BooleanBuilder();
        if (nameCondition != null) {
            builder.and(qCustomer.name.eq(nameCondition));
        }
        if (ageCondition > 0) {
            builder.and(qCustomer.age.goe(ageCondition));
        }
        return queryFactory
                .selectFrom(qCustomer)
                .where(builder)
                .fetch();

    }

    @Override
    public List<Customer> searchKeyword(String keyword) {

        BooleanExpression expression = qCustomer.name
                                            .containsIgnoreCase(keyword)
                                            .or(qCustomer.addr.containsIgnoreCase(keyword));
        return queryFactory
                .selectFrom(qCustomer)
                .where(expression)
                .fetch();
    }
}
