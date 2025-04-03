package com.franquicias.demo.application.service;

import com.franquicias.demo.application.port.IFranchiseService;
import com.franquicias.demo.domain.dto.Franchise;
import com.franquicias.demo.domain.mapper.FranchiseDataMapper;
import com.franquicias.demo.infrastructure.entity.FranchiseEntity;
import com.franquicias.demo.infrastructure.repository.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FranchiseService implements IFranchiseService {

    private static final Logger logger = LoggerFactory.getLogger(FranchiseService.class);
    private final FranchiseRepository franchiseRepository;

    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }


    @Override
    public Mono<Franchise> save(Franchise franchise) {
        logger.info("Saving franchise completed");
        Mono<FranchiseEntity> franchiseEntity = franchiseRepository.save(FranchiseDataMapper.fromFranchiseToFranchiseEntity(franchise));
        logger.info("Saved franchise");
        return franchiseEntity.map(FranchiseDataMapper::fromFranchiseEntityToFranchise)
                .switchIfEmpty(Mono.empty());
    }
}
