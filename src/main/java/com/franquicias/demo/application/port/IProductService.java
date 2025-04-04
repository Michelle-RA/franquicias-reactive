package com.franquicias.demo.application.port;

import com.franquicias.demo.domain.dto.ListBranchDTO;
import com.franquicias.demo.domain.dto.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface IProductService {
    Mono<Product> save(Product product);
    Mono<Object> delete(Long id);
    Mono<Product> updateStock(Integer stock, Long id);
    Flux<ListBranchDTO> findAll(Long idFranchise) throws InterruptedException;
}
