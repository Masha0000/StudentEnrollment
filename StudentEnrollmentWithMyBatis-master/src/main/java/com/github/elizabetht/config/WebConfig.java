package com.github.elizabetht.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
     * Веб-конфигурация - где лежит статика, какой формат имеют страницы итд, так же для себя сканирует контроллеры.
     */
    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = {"com.github.elizabetht.controller.my"})
    public class WebConfig extends WebMvcConfigurerAdapter {

        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/WEB-INF/html/");
            //если у вас *.jsp - то тут укажите jsp
            viewResolver.setSuffix(".html");
            return viewResolver;
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        /**
         * Контроллер favicon - иконки сайта на вкладке.
         */
     /*   @Controller
        static class FaviconController {
            @RequestMapping("favicon.ico")
            String favicon() {
                return "forward:/resources/images/favicon.ico";
            }
        }*/
    }


