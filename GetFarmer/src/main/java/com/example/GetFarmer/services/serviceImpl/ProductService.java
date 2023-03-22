package com.example.GetFarmer.services.serviceImpl;

import com.example.GetFarmer.domain.Product;
import com.example.GetFarmer.repository.ProductRepository;
import com.example.GetFarmer.services.serviceIf.ProductServiceIf;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements ProductServiceIf {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void editProduct(Long id, Double price, String description) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Product with id: " + id +" does not exist")
        );
        if (price != null && !Objects.equals(price, product.getPrice()) && price > 0){
            product.setPrice(price);
        }
        if (description != null && description.length() > 0 && !Objects.equals(description, product.getDescription())){
            product.setDescription(description);
        }
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Product with id: " + id +" does not exist")
        );
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("Product with id: " + id +" does not exist")
        );
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProductByCategory(String category){
        List<Product> productList = productRepository.getProductByCategory(category);
        if (productList.isEmpty()){
            throw new IllegalStateException("No products in demanded category: " + category);
        }
        return productList;
    }
}
