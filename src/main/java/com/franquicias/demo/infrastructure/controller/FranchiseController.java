package com.franquicias.demo.infrastructure.controller;

import com.franquicias.demo.application.port.IFranchiseService;
import com.franquicias.demo.domain.dto.Franchise;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
