package com.franquicias.demo.application.service;

import com.franquicias.demo.application.port.IProductService;
import com.franquicias.demo.domain.dto.ListBranchDTOClass;
import com.franquicias.demo.domain.dto.Product;
import com.franquicias.demo.domain.mapper.ProductDataMapper;
import com.franquicias.demo.infrastructure.controller.exception.NotFoundException;
import com.franquicias.demo.infrastructure.entity.ProductEntity;
import com.franquicias.demo.infrastructure.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> save(Product product) {
        logger.info("Saving product completed");
        Mono<ProductEntity> productEntity = productRepository.save(ProductDataMapper.fromProductToProductEntity(product));
        logger.info("Saved product");
        return productEntity.map(ProductDataMapper::fromProductEntityToProduct)
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Object> delete(Long id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Producto con ID " + id + " no encontrado")))
                .flatMap(product -> productRepository.delete(product));
    }


    @Override
    public Mono<Product> updateStock(Integer stock, Long id) {
        Mono<ProductEntity> productEntityMono = productRepository.findById(id);

        return productEntityMono.flatMap((existingProduct) -> {
            existingProduct.setStock(stock);
            return productRepository.save(existingProduct);
        }).map((ProductDataMapper::fromProductEntityToProduct));
    }

    @Override
    public Flux<ListBranchDTOClass> findAll(Long idFranchise) throws InterruptedException {
        logger.info("Searching List of Branch");
        Flux<ListBranchDTOClass> branchEntityFlux  = productRepository.findAllData(idFranchise);
        logger.info("Searching List of Branch completed");
        return branchEntityFlux.switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<Product> updateName(String nameProduct, Long id) {
        Mono<ProductEntity> ProductEntityMono = productRepository.findById(id);

        return ProductEntityMono.flatMap((existingProduct) -> {
            existingProduct.setName(nameProduct);
            return productRepository.save(existingProduct);
        }).map((ProductDataMapper::fromProductEntityToProduct));
    }


}
