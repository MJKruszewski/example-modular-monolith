package com.example.monolith;

import java.util.List;

public class ModuleAArchitectureTest extends BaseArchitectureTest {
    @Override
    protected String getPackageName() {
        return "com.example.monolith.moduleA";
    }

    @Override
    protected List<String> getAllowedPorts() {
        return List.of();
    }
}
