package com.casestudy5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @NotNull
    @DecimalMax("1000000.0") @DecimalMin("0.0")
    private double price;
    @NotBlank
    private String picture;
    @NotBlank
    @Size(min = 3, max = 50)
    private String description;
    @NotNull
    @Max(value = 1000)
    private int inventory;
    @NotBlank
    @Size(min = 3, max = 50)
    private String status;
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "productId"), inverseJoinColumns = @JoinColumn(name = "categoryId") )
    Set<Category> categories= new HashSet<>();


    public Product(@NotBlank
                   @Size(min = 3, max = 50) String name,
                   @NotNull
                   @DecimalMax("1000000.0") @DecimalMin("0.0")  double price,
                   @NotBlank
                   String picture,
                   @NotBlank
                   @Size(min = 3, max = 50)
                   String description,
                   @NotNull
                   @Max(value = 1000)
                   int inventory,
                   @NotBlank
                   @Size(min = 3, max = 50)
                   String status,
                   Set<Category> categories) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.inventory = inventory;
        this.status = status;
        this.categories = categories;
    }
}
