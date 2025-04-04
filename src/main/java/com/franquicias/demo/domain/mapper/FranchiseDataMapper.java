package com.franquicias.demo.domain.mapper;

import com.franquicias.demo.domain.dto.Franchise;
import com.franquicias.demo.infrastructure.entity.FranchiseEntity;


public class FranchiseDataMapper {
    public static FranchiseEntity fromFranchiseToFranchiseEntity(Franchise franchise){
        return FranchiseEntity.builder()
                .id(franchise.getId())
                .name(franchise.getName())
                .build();
    }

    public static Franchise fromFranchiseEntityToFranchise(FranchiseEntity franchise){
        return Franchise.builder()
                .id(franchise.getId())
                .name(franchise.getName())
                .build();
    }
}
