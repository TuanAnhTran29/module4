package com.casestudy5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

@Entity
@Table(name = "bills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    private User user;

    private Date date;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Product.class)
    private List<Product> products;

    private int totalCost;
    private String status;

    public Bill(User user, Date date, List<Product> products, int totalCost, String status) {
        this.user = user;
        this.date = date;
        this.products = products;
        this.totalCost = totalCost;
        this.status = status;
    }
}
