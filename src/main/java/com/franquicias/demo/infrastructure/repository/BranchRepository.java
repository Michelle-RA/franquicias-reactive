package com.franquicias.demo.infrastructure.repository;

import com.franquicias.demo.infrastructure.entity.BranchEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BranchRepository extends R2dbcRepository<BranchEntity, Long> {
}
