package com.example.GetFarmer.services.serviceIf;

import com.example.GetFarmer.domain.Product;

import java.util.List;

public interface ProductServiceIf {
    void addProduct(Product product);
    void editProduct(Long id, Double price, String description);
    Product getProduct(Long id);
    List<Product> getProductList();
    void deleteProduct(Long id);
    List<Product> getProductByCategory(String category);
}
