package com.ch07.repository.shop;

import com.ch07.DTO.CustomerDTO;
import com.ch07.DTO.ProductAggDTO;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopQueryDslTest {

    @Autowired
    private JPAQueryFactory queryFactory;

    private QCustomer qCustomer = QCustomer.customer;
    private QProduct qProduct = QProduct.product;
    private QOrder qOrder = QOrder.order;

    @Test
    public void Test01() {
        List<Product> products = queryFactory
                .selectFrom(qProduct)
                .fetch();
        System.out.println(products);
    }
    @Test
    public void Test02() {
        List<Product> products = queryFactory
                                        .select(
                                                Projections.fields(
                                                        Product.class,
                                                        qProduct.productId,
                                                        qProduct.productName,
                                                        qProduct.price
                                                )
                                        )
                                        .from(qProduct)
                                        .fetch();
        System.out.println(products);

    }
    @Test
    public void Test03() {
        List<Customer> customers1 =
        queryFactory.selectFrom(qCustomer)
                .where(qCustomer.name.eq("김유신")).fetch();
        List<Customer> customers2 =
        queryFactory.selectFrom(qCustomer)
                .where(qCustomer.name.ne("김유신")).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
    }
    @Test
    public void Test04() {
        List<Customer> customers1 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List<Customer> customers2 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        List<Customer> customers3 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        List<Customer> customers4 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);
        System.out.println(customers4);
    }
    @Test
    public void Test05() {
        List<Customer> customers1 = queryFactory.selectFrom(qCustomer).where(qCustomer.addr.in("서울","김해")).fetch();

        System.out.println(customers1);
    }
    @Test
    public void Test06() {
        List<Customer> customers1 = queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.like("%신"))
                .fetch();

        System.out.println(customers1);
    }
    @Test
    public void Test07() {
        List<Product> products = queryFactory
                            .selectFrom(qProduct)
                            .where(qProduct.stock.gt(0))
                            .orderBy(qProduct.price.desc())
                            .fetch();
        System.out.println(products);
    }
    @Test
    public void Test08() {
        List<Product> products = queryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(3)
                .fetch();


        System.out.println(products);
     }
    @Test
    public void Test09() {
        ProductAggDTO products = queryFactory
                .select(
                        Projections.fields(
                                ProductAggDTO.class,
                                qProduct.price.sum().as("priceSum"),
                                qProduct.price.avg().as("priceAvg"),
                                qProduct.price.max().as("priceMax"),
                                qProduct.price.min().as("priceMin")
                        )
                )
                .from(qProduct)
                .fetchOne();
        System.out.println(products);
    }
    @Test
    public void Test10() {
        List<CustomerDTO> customerDTOs = queryFactory
                                            .select(
                                                    Projections.fields(
                                                            CustomerDTO.class,
                                                            qOrder.customer.custId,
                                                            qOrder.customer.name,
                                                            qOrder.customer.custId.count().as("orderCount")
                                                    )
                                            )
                                            .from(qOrder)
                                            .where(qOrder.orderStatus.eq(1))
                                            .groupBy(qOrder.customer.custId)
                                            .having(qOrder.customer.custId.count().goe(2))
                                            .fetch();
    }

    @Transactional
    @Test
    public void Test11() {
        List<Tuple> result = queryFactory
                                .select(qOrder,qCustomer)
                                .from(qOrder)
                                .join(qCustomer)
                                .on(qOrder.customer.eq(qCustomer))
                                .fetch();
        System.out.println(result);
    }
    @Test
    public void Test12() {

    }
    @Test
    public void Test13() {

    }
}