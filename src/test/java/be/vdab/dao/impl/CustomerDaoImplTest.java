package be.vdab.dao.impl;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//https://github.com/howtoprogram/junit5-examples/blob/master/junit5-maven-example/src/test/java/com/howtoprogram/junit5/BasicSalaryCalculatorTest.java
class CustomerDaoImplTest {
    private Customer customer;
    private User user;

    @BeforeEach
    void init() {
        customer = new Customer("user123", "password123",
                '1', "Armani", "Giorgio ", "jan.armani@armani.com",
                "Via Alessandro Manzoni 31, 20121 Milano MI, Italy");
        user = new User();
    }

    @AfterEach
    void tearDown() {
        customer = null;
        user = null;
    }

    @Test
    void findCustomer() {
    }

    @Test
    void findByLoginAndUsername() {
        String username = "user123";
        user.setUsername(username);

        String password = "password123";
        user.setPassword(password);



    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

}