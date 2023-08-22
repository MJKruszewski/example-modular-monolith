package com.example.monolith.moduleA.infrastructure.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface DomainAEntityRepository extends MongoRepository<DomainAEntity, UUID> {

}
