package com.reightvoid.jja.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Collection;
import java.util.List;

public class AdminRegistry {
    private final Map<String, AdminModelDefinition> models = new LinkedHashMap<>();

    public void register(AdminModelDefinition definition) {
        Objects.requireNonNull(definition);
        String path = definition.path();
        if (path == null || !path.matches("[a-z][a-z0-9-]*")) {
            throw new IllegalArgumentException("Invalid admin model path: " + path);
        }
        if (definition.entityClass() == null
                || definition.name() == null
                || definition.name().isBlank()) {
            throw new IllegalArgumentException(
                    "Invalid admin model definition");
        }

        if (models.containsKey(path)) {
            throw new IllegalArgumentException(
                    "Model already registered: " + path);
        }
        models.put(path, definition);
    }

    public AdminModelDefinition get(String path) {
        return models.get(path);
    }

    public Collection<AdminModelDefinition> getAll() {
        return List.copyOf(models.values());
    }
}
