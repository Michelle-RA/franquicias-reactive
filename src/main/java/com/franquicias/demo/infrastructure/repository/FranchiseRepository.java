package com.franquicias.demo.infrastructure.repository;

import com.franquicias.demo.infrastructure.entity.FranchiseEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FranchiseRepository extends R2dbcRepository<FranchiseEntity, Long> {
}
