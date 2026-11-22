package com.reightvoid.jja.api;

import java.util.function.Consumer;

import com.reightvoid.jja.core.AdminModelDefinition;
import com.reightvoid.jja.core.AdminRegistry;

public class JjaAdmin {
    private final AdminRegistry registry;

    public JjaAdmin(AdminRegistry registry) {
        this.registry = registry;
    }

    public static JjaAdmin create(AdminRegistry registry) {
        return new JjaAdmin(registry);
    }
     public JjaAdmin register(Class<?> entityClass) {
        return register(entityClass, config -> {});
    }


    public JjaAdmin register(
            Class<?> entityClass,
            Consumer<AdminModelConfig> customizer) {
                AdminModelConfig config = new AdminModelConfig();
                config.name(entityClass.getSimpleName());
                config.path(entityClass.getSimpleName().toLowerCase());
                customizer.accept(config);
                registry.register(new AdminModelDefinition(entityClass, config));
        return this;
    }

    public AdminRegistry getRegistry() {
        return registry;
    }
}
