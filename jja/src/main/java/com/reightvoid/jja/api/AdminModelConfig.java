package com.reightvoid.jja.api;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class AdminModelConfig {
    private String name;
    private String path;

    private List<String> listDisplay = new ArrayList<>();
    private List<String> searchFields = new ArrayList<>();
    private List<String> listFilters = new ArrayList<>();

    public AdminModelConfig name(String name) {
        this.name = name;
        return this;
    }

    public AdminModelConfig path(String path) {
        this.path = path;
        return this;
    }

    public AdminModelConfig listDisplay(String... fields) {
        listDisplay.addAll(List.of(fields));
        return this;
    }

    public AdminModelConfig searchFields(String... fields) {
        searchFields.addAll(List.of(fields));
        return this;
    }

    public AdminModelConfig listFilters(String... fields) {
        listFilters.addAll(List.of(fields));
        return this;
    }
}
