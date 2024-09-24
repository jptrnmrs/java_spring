package com.ch07.repository;

import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("a101");
        System.out.println(entity);

    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("김유신");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("김유신");
        System.out.println(users);
    }

    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("a205", "김유신");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> users = user1Repository.findUser1ByUidOrName("a202","김유신");
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThan(23);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanEqual(23);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> users = user1Repository.findUser1ByAgeLessThan(23);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeLessThanEqual(23);
        System.out.println(users);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> users = user1Repository.findUser1ByAgeBetween(20,30);
        System.out.println(users);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> users = user1Repository.findUser1ByNameLike("김유진");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> users = user1Repository.findUser1ByNameContains("찬");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> user1s = user1Repository.findUser1ByNameStartsWith("장");
    }

    @Test
    void findUser1ByNameEndsWith() {
        List<User1> user1s = user1Repository.findUser1ByNameEndsWith("정");
    }

    @Test
    void findUser1ByOrderByName() {
        List<User1> users = user1Repository.findUser1ByOrderByName();
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
        List<User1> users = user1Repository.findUser1ByOrderByAgeAsc();
        System.out.println(users);
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
        List<User1> users = user1Repository.findUser1ByOrderByAgeDesc();
        System.out.println(users);

    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanOrderByAgeDesc(23);
        System.out.println(users);
    }

    @Test
    void selectUser1UnderAge30() {
    }

    @Test
    void selectUser1WhereName() {
    }

    @Test
    void selectUser1WhereNameParam() {
    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("p101");
        for (Object[] o : list) {
            System.out.println(o[0].toString());
        }
    }
}