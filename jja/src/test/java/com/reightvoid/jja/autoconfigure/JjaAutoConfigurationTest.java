package com.reightvoid.jja.autoconfigure;

import com.reightvoid.jja.annotation.AdminModel;
import com.reightvoid.jja.core.AdminRegistry;
import com.reightvoid.jja.scanner.AdminModelScanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

class JjaAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner =
            new ApplicationContextRunner()
                    .withUserConfiguration(
                            JjaAutoConfiguration.class
                    );

    @Test
    void shouldCreateRegistryAndScanner() {

        contextRunner.run(context -> {

            assertThat(context)
                    .hasSingleBean(AdminRegistry.class);

            assertThat(context)
                    .hasSingleBean(AdminModelScanner.class);
        });
    }

    @Test
    void shouldRegisterAnnotatedModel() {

        contextRunner
                .withUserConfiguration(TestConfiguration.class)
                .run(context -> {

                    AdminRegistry registry =
                            context.getBean(AdminRegistry.class);

                    assertThat(registry.get("products"))
                            .isNotNull();

                    assertThat(registry.get("products").entityClass())
                            .isEqualTo(Product.class);
                });
    }

    static class Product {
    }

    @AdminModel(
            value = Product.class,
            name = "Products",
            path = "products"
    )
    static class ProductAdmin {
    }

    @Configuration(proxyBeanMethods = false)
    static class TestConfiguration {

        @Bean
        ProductAdmin productAdmin() {
            return new ProductAdmin();
        }
    }
}