package com.reightvoid.jja.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AdminRegistryTest {
    static class Product {
    };

    @Test
    void shouldRegistryModel() {
        AdminRegistry registry = new AdminRegistry();
        AdminModelDefinition definition = new AdminModelDefinition(
                Product.class, "Products", "products");
        registry.register(definition);
        assertEquals(definition, registry.get("products"));
    }

    @Test
    void shouldRejectDuplicatePath() {
        AdminRegistry registry = new AdminRegistry();
        AdminModelDefinition definition = new AdminModelDefinition(
                Product.class, "Products", "../products");
        assertThrows(IllegalArgumentException.class, () -> registry.register(definition));

    }

    @Test
    void shouldReturnAllModels() {
        AdminRegistry registry = new AdminRegistry();
        registry.register(
                new AdminModelDefinition(
                        Product.class,
                        "Products",
                        "products"));

        assertEquals(1, registry.getAll().size());
    }

    @Test
    void shouldRejectNullModelName() {
        AdminRegistry registry = new AdminRegistry();
        AdminModelDefinition definition = new AdminModelDefinition(Product.class, null, "path");
        assertThrows(IllegalArgumentException.class, () -> registry.register(definition));
    }

    @Test
    void shouldReturnNullForUnknownModel() {
        AdminRegistry registry = new AdminRegistry();

        assertNull(registry.get("unknown"));
    }

}
