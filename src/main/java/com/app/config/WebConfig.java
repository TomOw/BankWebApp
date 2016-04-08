package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Tomasz on 28.03.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.app")

public class WebConfig extends WebMvcConfigurerAdapter{
    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    public void configureDefaultServerletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
