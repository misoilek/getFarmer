package com.example.GetFarmer.domain;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_id_sequence",
            sequenceName = "product_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )
    private Long productId;
    @NotNull
    private String category;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private String description;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    public Product(@NotNull String category, @NotNull String name, @NotNull Double price, @NotNull String description, @NotNull User user) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.description = description;
        this.user = user;
    }

    public Product() {

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long id) {
        this.productId = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
