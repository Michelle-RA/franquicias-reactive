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
@Table(name = "sucursales")
@Inheritance(strategy= InheritanceType.JOINED)
@ToString
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private FranchiseEntity franchise;
}
