package com.example.monolith.moduleA.application.port;

import com.example.monolith.moduleA.application.port.vo.ModuleAPortVo;
import com.example.monolith.moduleA.domain.DomainA;
import com.example.monolith.moduleA.domain.DomainARepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
final class ModuleAReadAdapter implements ModuleAReadPort {
    private final DomainARepository domainARepository;
    private final ModuleAReadMapper moduleAReadMapper;

    @Override
    public Optional<ModuleAPortVo> getById(UUID id) {
        return domainARepository.findById(id).map(moduleAReadMapper::map);
    }

    @Mapper(componentModel = "spring")
    interface ModuleAReadMapper {
        ModuleAPortVo map(DomainA domainAEntity);
    }
}
