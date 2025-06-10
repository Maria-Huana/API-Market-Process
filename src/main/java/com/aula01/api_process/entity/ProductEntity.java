package com.aula01.api_process.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

    @Column
     private String name;

    @Column
     private BigDecimal price;

    @Column
     private int stock;

    @Column
     private int reserve;

    @Column
     private Date created_at = new Date();

}
