package com.walmartapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_inventory")
@Data
public class ProductInventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer stock;

    private String warehouseLocation;

    private LocalDateTime lastUpdated;

    @OneToOne(mappedBy = "inventory")
    private ProductEntity product;

}
