package com.example.monolith.moduleA.application.port;

import com.example.monolith.moduleA.application.port.vo.ModuleAPortVo;

import java.util.Optional;
import java.util.UUID;

public interface ModuleAReadPort {
    Optional<ModuleAPortVo> getById(UUID id);
}
