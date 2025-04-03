package com.franquicias.demo.application.port;

import com.franquicias.demo.domain.dto.Franchise;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface IFranchiseService {
    Mono<Franchise> save(Franchise franchise);
}
