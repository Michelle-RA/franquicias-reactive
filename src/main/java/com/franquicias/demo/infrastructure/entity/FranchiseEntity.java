package com.franquicias.demo.infrastructure.entity;



import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "franquicias")
@Inheritance(strategy= InheritanceType.JOINED)
@ToString
public class FranchiseEntity {
    @Id
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nombre")
    private String name;
}
