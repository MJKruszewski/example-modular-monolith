package com.example.monolith.moduleA.infrastructure.dao;

import com.example.monolith.moduleA.domain.DomainA;
import com.example.monolith.moduleA.domain.DomainARepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
final class DbDomainARepository implements DomainARepository {
    private final DomainAEntityRepository domainAEntityRepository;
    private final DomainAEntityMapper domainAEntityMapper;

    @Override
    public Optional<DomainA> findById(UUID id) {
        return domainAEntityRepository.findById(id).map(domainAEntityMapper::map);
    }

    @Mapper(componentModel = "spring")
    interface DomainAEntityMapper {
        DomainA map(DomainAEntity domainAEntity);
    }
}
