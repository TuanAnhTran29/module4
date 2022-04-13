package com.casestudy5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "turnovers")
@CrossOrigin(origins = "*")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turnover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    User user;

    private Integer revenue;

    public Turnover(User user, Integer revenue) {
        this.user = user;
        this.revenue = revenue;
    }
}
