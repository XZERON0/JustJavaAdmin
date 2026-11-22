package com.reightvoid.jja.core;

import com.reightvoid.jja.api.AdminModelConfig;

public record AdminModelDefinition (
    Class<?> entityClass, 
    AdminModelConfig config
) {
    public String name()
    {
        return config.getName();
    }
    public String path(){
        return config.getPath();
    }
}
