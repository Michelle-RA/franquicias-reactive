package com.franquicias.demo.application.service;

import com.franquicias.demo.application.port.IBranchService;
import com.franquicias.demo.domain.dto.Branch;
import com.franquicias.demo.domain.mapper.BranchDataMapper;
import com.franquicias.demo.infrastructure.entity.BranchEntity;
import com.franquicias.demo.infrastructure.repository.BranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BranchService implements IBranchService{
    private static final Logger logger = LoggerFactory.getLogger(BranchService.class);
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Mono<Branch> save(Branch branch) {
        logger.info("Saving branch completed");
        Mono<BranchEntity> branchEntity = branchRepository.save(BranchDataMapper.fromBranchToBranchEntity(branch));
        logger.info("Saved branch");
        return branchEntity.map(BranchDataMapper::fromBranchEntityToBranch)
                .switchIfEmpty(Mono.empty());
    }
}
