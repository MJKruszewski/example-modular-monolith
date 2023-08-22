package com.example.monolith.moduleA.infrastructure.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
class DomainAEntity {
    UUID id;

}
