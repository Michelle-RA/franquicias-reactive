package com.franquicias.demo.infrastructure.controller;

import com.franquicias.demo.application.port.IBranchService;
import com.franquicias.demo.domain.dto.Branch;
import com.franquicias.demo.domain.dto.Franchise;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("branch")
public class BranchController {
    private final IBranchService iBranchService;

    public BranchController(IBranchService iBranchService) {
        this.iBranchService = iBranchService;
    }

    @PostMapping
    public ResponseEntity<Mono<Branch>> save(@Valid @RequestBody Branch branch){
        return new ResponseEntity<>(iBranchService.save(branch), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mono<Branch>> update(@RequestParam String nameBranch, @PathVariable Long id){
        return ResponseEntity.ok(iBranchService.updateName(nameBranch, id));
    }
}
