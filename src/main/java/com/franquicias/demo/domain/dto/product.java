package com.franquicias.demo.domain.dto;

import com.franquicias.demo.infrastructure.entity.BranchEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class product {
    private Long id;
    private String name;
    private int stock;
    private BranchEntity branch_id ;
}
