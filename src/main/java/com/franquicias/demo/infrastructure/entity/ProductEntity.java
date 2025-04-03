package com.franquicias.demo.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
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
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "sucursal", nullable = false)
    private BranchEntity branch_id ;
}
