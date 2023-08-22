package com.example.monolith;

import java.util.List;

public class ModuleBArchitectureTest extends BaseArchitectureTest {
    @Override
    protected String getPackageName() {
        return "com.example.monolith.moduleB";
    }

    @Override
    protected List<String> getAllowedPorts() {
        return List.of(
                "com.example.monolith.moduleA.application.port.."
        );
    }
}
