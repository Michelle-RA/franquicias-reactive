package com.franquicias.demo.application.port;

import com.franquicias.demo.domain.dto.Branch;
import com.franquicias.demo.domain.dto.Franchise;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface IBranchService {
    Mono<Branch> save(Branch branch);
    Mono<Branch> updateName(String nameBranch, Long id);
}
