package com.casestudy5.dto.custom;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dto")
public class CommonEntity {
    @Id
    Long id;
}
