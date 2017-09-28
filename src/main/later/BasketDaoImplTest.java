package be.vdab.dao.impl;

import be.vdab.entiteiten.Basket;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import be.vdab.entiteiten.Basket;
import be.vdab.entiteiten.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;


//https://github.com/howtoprogram/junit5-examples/blob/master/junit5-maven-example/src/test/java/com/howtoprogram/junit5/BasicSalaryCalculatorTest.java
class BasketDaoImplTest {

    private Basket basket;
    private Product product;

    @BeforeEach
    void setUp() {
        basket = new Basket();
        product = new Product();
    }

    @AfterEach
    void tearDown() {
        basket = null;
        product = null;
    }

    @Test
    void saveOrUpdateBasket() {

    }

    @Test
    void addProductToBasket() {
    }

    @Test
    void removeProductFromBasket() {
    }

    @Test
    void getBasket() {
    }

    @Test
    void clearBasket() {
    }

}