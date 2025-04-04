package com.franquicias.demo.infrastructure.repository;

import com.franquicias.demo.infrastructure.entity.ProductEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProductRepository extends R2dbcRepository<ProductEntity, Long> {
}
