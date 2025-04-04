package com.franquicias.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListBranchDTOClass  {
    private Long branchId;
    private String nameBranch;
    private Long productId;
    private String nameProduct;
    private Integer stock;
}
