package com.franquicias.demo.infrastructure.repository;

import com.franquicias.demo.domain.dto.ListBranchDTO;
import com.franquicias.demo.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends R2dbcRepository<ProductEntity, Long> {

    @Query("""
            SELECT s.id AS branchId,
                   s.name AS nameBranch,
                   p.id AS productId,
                   p.name AS nameProduct,
                   p.stock
            FROM sucursales s
            LEFT JOIN productos p ON p.branch_id = s.id
            WHERE s.franchise = :franchiseId
            AND (p.stock IS NULL OR p.stock = (
                SELECT MAX(p2.stock)
                FROM productos p2
                WHERE p2.branch_id = s.id
            ))
            ORDER BY s.id;
            """)
    Flux<ListBranchDTO> findAll(Long franchiseId);
}

