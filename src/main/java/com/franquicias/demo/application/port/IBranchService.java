package com.franquicias.demo.application.port;

import com.franquicias.demo.domain.dto.Branch;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface IBranchService {
    Mono<Branch> save(Branch branch);
}
