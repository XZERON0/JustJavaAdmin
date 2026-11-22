package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.reightvoid.jja.api.JjaAdmin;
import com.reightvoid.jja.core.AdminRegistry;
@Configuration 
public class AdminConfig {
    @Autowired 
    private AdminRegistry registry;
    @Bean
    public JjaAdmin jjaAdmin() {
        return JjaAdmin.create(registry)
                .register(Product.class, config -> config
                        .name("Products")
                        .path("products")
                        .listDisplay("id", "name", "price")
                        .searchFields("name"))
                .register(User.class);
    }
}
