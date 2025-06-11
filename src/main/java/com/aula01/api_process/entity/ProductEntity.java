package com.aula01.api_process.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Timer;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

    @Column(nullable = false)
     private String name;

    @Column(nullable = false)
     private BigDecimal price;

    @Column(nullable = false)
     private int stock;

    @Column()
    private int reserve = 0;

    @Column
     private Date created_at = new Date();


}
