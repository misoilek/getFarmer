package com.example.GetFarmer.repository;

import com.example.GetFarmer.domain.Product;
import com.example.GetFarmer.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTestProduct;
    @Autowired
    private UserRepository underTestUser;
    @AfterEach
    void tearDown(){
        underTestProduct.deleteAll();
        underTestUser.deleteAll();
    }
    @Test
    void itShouldGetProductByCategory() {
        //input
        User user = new User(
                "Jozef Rovny",
                "jozef@gmail.com",
                "0911506321"
                );
        Product productOne = new Product(
                "zelenina",
                "zemiaky",
                2.5,
                "pestovane vonku",
                user
                );
        Product productTwo = new Product(
                "zelenina",
                "uhorky",
                1.5,
                "pestovane v skleniku",
                user
        );
        List<Product> productList = new ArrayList<Product>();
        productList.add(productOne);
        productList.add(productTwo);
        underTestProduct.save(productOne);
        underTestProduct.save(productTwo);
        underTestUser.save(user);

        //when
        List<Product> expected = underTestProduct.getProductByCategory("zelenina");

        //then
        assertEquals(productList, expected);
    }

    @Test
    void itShouldNotGetProductByCategory() {
        //input
        User user = new User(
                "Jozef Rovny",
                "jozef@gmail.com",
                "0911506321"
        );
        Product productOne = new Product(
                "zelenina",
                "zemiaky",
                2.5,
                "pestovane vonku",
                user
        );
        Product productTwo = new Product(
                "zelenina",
                "uhorky",
                1.5,
                "pestovane v skleniku",
                user
        );
        List<Product> productList = new ArrayList<Product>();
        productList.add(productOne);
        productList.add(productTwo);
        underTestProduct.save(productOne);
        underTestProduct.save(productTwo);
        underTestUser.save(user);

        //when
        List<Product> expected = underTestProduct.getProductByCategory("ovocie");

        //then
        assertNotEquals(productList, expected);
    }
}