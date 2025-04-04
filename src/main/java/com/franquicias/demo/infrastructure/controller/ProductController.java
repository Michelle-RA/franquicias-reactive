package com.franquicias.demo.infrastructure.controller;

import com.franquicias.demo.application.port.IProductService;
import com.franquicias.demo.domain.dto.Franchise;
import com.franquicias.demo.domain.dto.ListBranchDTOClass;
import com.franquicias.demo.domain.dto.Product;
import com.franquicias.demo.domain.mapper.BranchDataMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

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
    public ResponseEntity<Mono<Map<String, String>>> delete(@PathVariable Long id) {
        Mono<Map<String, String>> response = iProductService.delete(id)
                .thenReturn(Map.of("message", "Producto eliminado exitosamente"));
        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Mono<Product>> update(@RequestParam Integer stock, @PathVariable Long id){
        return ResponseEntity.ok(iProductService.updateStock(stock, id));
    }

    @GetMapping
    public ResponseEntity<Flux<ListBranchDTOClass>> findAll(@RequestParam Long franchiseId) throws InterruptedException {
        Flux<ListBranchDTOClass> branch = iProductService.findAll(franchiseId);
        return ResponseEntity.ok(branch.switchIfEmpty(Flux.empty()));
    }

    @PatchMapping("nameProduct/{id}")
    public ResponseEntity<Mono<Product>> updateNameBranch(@RequestParam String nameProduct, @PathVariable Long id){
        return ResponseEntity.ok(iProductService.updateName(nameProduct, id));
    }

}
