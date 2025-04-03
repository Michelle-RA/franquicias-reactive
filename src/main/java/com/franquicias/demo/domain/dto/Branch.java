package com.franquicias.demo.domain.dto;

import com.franquicias.demo.infrastructure.entity.FranchiseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    private Long id;
    private String name;
    private FranchiseEntity franchise;
}
