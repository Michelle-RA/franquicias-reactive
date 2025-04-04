package com.franquicias.demo.infrastructure.controller;

import com.franquicias.demo.application.port.IFranchiseService;
import com.franquicias.demo.domain.dto.Franchise;
import com.franquicias.demo.domain.dto.Product;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("franchise")
public class FranchiseController {

    private final IFranchiseService iFranchiseService;

    public FranchiseController(IFranchiseService iFranchiseService) {
        this.iFranchiseService = iFranchiseService;
    }

    @PostMapping
    public ResponseEntity<Mono<Franchise>> save(@Valid @RequestBody Franchise franchise){
        return new ResponseEntity<>(iFranchiseService.save(franchise), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mono<Franchise>> update(@RequestParam String nameFranchise, @PathVariable Long id){
        return ResponseEntity.ok(iFranchiseService.updateName(nameFranchise, id));
    }

}
