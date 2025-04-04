package com.franquicias.demo.application.port;

import com.franquicias.demo.domain.dto.Branch;
import com.franquicias.demo.domain.dto.Franchise;
import com.franquicias.demo.domain.dto.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface IFranchiseService {
    Mono<Franchise> save(Franchise franchise);
    Mono<Franchise> updateName(String nameFranchise, Long id);
}
