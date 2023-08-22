package com.example.monolith.moduleB.application.handler;

import com.example.monolith.moduleA.application.port.ModuleAReadPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExampleHandler {
    private final ModuleAReadPort moduleAReadPort;

    private void someMethod() {
        var x = moduleAReadPort.getById(UUID.randomUUID());
        //todo do some stuff with x
    }
}
