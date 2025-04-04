package com.franquicias.demo.infrastructure.controller;

import com.franquicias.demo.application.port.IProductService;
import com.franquicias.demo.domain.dto.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
public class ProductController {
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    public ResponseEntity<Mono<Product>> save(@Valid @RequestBody Product product){
        return new ResponseEntity<>(iProductService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Object>> delete(@PathVariable Long id){
        Mono<Object> res = iProductService.delete(id);
        return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mono<Product>> update(@RequestParam Integer stock, @PathVariable Long id){
        return ResponseEntity.ok(iProductService.updateStock(stock, id));
    }
}
