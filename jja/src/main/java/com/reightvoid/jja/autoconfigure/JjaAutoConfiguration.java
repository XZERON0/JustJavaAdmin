package com.reightvoid.jja.autoconfigure;

import com.reightvoid.jja.controller.AdminController;
import com.reightvoid.jja.core.AdminRegistry;
import com.reightvoid.jja.scanner.AdminModelScanner;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class JjaAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AdminRegistry adminRegistry() {
        return new AdminRegistry();
    }

    @Bean
    @ConditionalOnMissingBean
    public AdminModelScanner adminModelScanner(
            ApplicationContext context,
            AdminRegistry registry
    ) {
        return new AdminModelScanner(context, registry);
    }
    @Bean 
    @ConditionalOnMissingBean 
    public AdminController adminController(AdminRegistry registry)
    {
        return new AdminController(registry);
    }
    
}