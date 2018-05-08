package com.github.elizabetht.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
     * Конфигурация рута - сканирует все компоненты спринга в приложении, кроме конфига, где описана статика и контроллеры. ВАЖНО: в этом *
     * конфиге котроллеры ТОЖЕ сканируются. В этом же конфиге можно писать свои бины.
     */
    @Configuration
    @ComponentScan(basePackages = "com.github.elizabetht",
            excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfig.class)})
    public class RootConfig {
    }

