package com.example.GetFarmer.services.serviceImpl;

import com.example.GetFarmer.domain.Product;
import com.example.GetFarmer.domain.User;
import com.example.GetFarmer.repository.ProductRepository;
import com.example.GetFarmer.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @Mock private ProductRepository productRepository;
    @Mock private UserRepository userRepository;
    private ProductService underTestProduct;
    private UserService underTestUser;

    @BeforeEach
    void setUp() {
        underTestProduct = new ProductService(productRepository);
        underTestUser = new UserService(userRepository);
    }

    @Test
    void addProduct() {
        //input
        User user = new User(
                "Jozef Rovny",
                "jozef@gmail.com",
                "0911506321"
        );
        Product product = new Product(
                "zelenina",
                "zemiaky",
                2.5,
                "pestovane vonku",
                user
        );

        //when
        underTestUser.addUser(user);
        underTestProduct.addProduct(product);

        //then
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();
        assertThat(capturedProduct).isEqualTo(product);
    }
}