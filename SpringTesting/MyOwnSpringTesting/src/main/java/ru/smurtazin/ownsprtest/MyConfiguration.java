package ru.smurtazin.ownsprtest;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.smurtazin.ownsprtest");
@EnableAutoConfiguration
public class MyConfiguration extends WebMvcConfigurerAdapter {



}
