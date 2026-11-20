package com.reightvoid.jja.scanner;

import com.reightvoid.jja.annotation.AdminModel;
import com.reightvoid.jja.core.AdminModelDefinition;
import com.reightvoid.jja.core.AdminRegistry;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;

public class AdminModelScanner implements SmartInitializingSingleton {

    private final ApplicationContext context;
    private final AdminRegistry registry;

    public AdminModelScanner(
            ApplicationContext context,
            AdminRegistry registry
    ) {
        this.context = context;
        this.registry = registry;
    }

    @Override
    public void afterSingletonsInstantiated() {

        for (String beanName : context.getBeanDefinitionNames()) {

            Class<?> beanType = context.getType(beanName);

            if (beanType == null) {
                continue;
            }

            Class<?> targetType =
                    ClassUtils.getUserClass(beanType);

            AdminModel annotation =
                    AnnotatedElementUtils.findMergedAnnotation(
                            targetType,
                            AdminModel.class
                    );

            if (annotation == null) {
                continue;
            }

            registry.register(
                    new AdminModelDefinition(
                            annotation.value(),
                            annotation.name(),
                            annotation.path()
                    )
            );
        }
    }
}