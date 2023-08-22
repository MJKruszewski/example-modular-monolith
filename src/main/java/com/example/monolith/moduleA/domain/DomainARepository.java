package com.example.monolith.moduleA.domain;

import java.util.Optional;
import java.util.UUID;

public interface DomainARepository {

    Optional<DomainA> findById(UUID id);
}
