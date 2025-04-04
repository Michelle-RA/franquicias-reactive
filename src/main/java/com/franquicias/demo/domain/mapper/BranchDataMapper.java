package com.franquicias.demo.domain.mapper;

import com.franquicias.demo.domain.dto.Branch;
import com.franquicias.demo.domain.dto.ListBranchDTOClass;
import com.franquicias.demo.infrastructure.entity.BranchEntity;

public class BranchDataMapper {
    public static BranchEntity fromBranchToBranchEntity(Branch branch){
        return BranchEntity.builder()
                .id(branch.getId())
                .name(branch.getName())
                .franchise(branch.getFranchise())
                .build();
    }

    public static Branch fromBranchEntityToBranch(BranchEntity branchEntity){
        return Branch.builder()
                .id(branchEntity.getId())
                .name(branchEntity.getName())
                .franchise(branchEntity.getFranchise())
                .build();
    }
}
