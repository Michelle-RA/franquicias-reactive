package com.franquicias.demo.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
@Inheritance(strategy= InheritanceType.JOINED)
@ToString
@DynamicUpdate
public class ProductEntity {
    @Id
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int stock;
    private Long branchId ;
}
