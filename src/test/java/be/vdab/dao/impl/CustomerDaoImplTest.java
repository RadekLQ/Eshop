package be.vdab.dao.impl;

import be.vdab.entiteiten.Customer;
import be.vdab.entiteiten.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    void testFindByLoginAndUsernameWithValidInput() {
        String username = "user123";
        user.setUsername(username);

        String password = "password123";
        user.setPassword(password);

        User expectedUser = new User("user123", "password123");
        assertEquals(expectedUser, user);
    }

    @DisplayName("Test findByLoginAndUsername with invalid input")
    @Test
    void testFindByLoginAndUsernameWithInvalidUsername() {

        String username = "";
        String password = "password123";

        assertThrows(IllegalArgumentException.class, () -> {
            user.setUsername(username);
        });
    }

    @DisplayName("Test findByLoginAndUsername with invalid input")
    @Test
    void testFindByLoginAndUsernameWithInvalidPassword() {

        String password = "";

        assertThrows(IllegalArgumentException.class, () -> {
            user.setPassword(password);
        });
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

}