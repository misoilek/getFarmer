package com.example.GetFarmer.controller;

import com.example.GetFarmer.domain.Product;
import com.example.GetFarmer.services.serviceImpl.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping("{id}")
    public void editProduct(@PathVariable("id") Long id,
                            @RequestParam(required = false) Double price,
                            @RequestParam(required = false) String description){
        productService.editProduct(id, price, description);
    }

    @GetMapping(path = "{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @GetMapping()
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @GetMapping(path = "category/{category}")
    public List<Product> getProductByCategory(@PathVariable("category") String category){
        return productService.getProductByCategory(category);
    }
}
