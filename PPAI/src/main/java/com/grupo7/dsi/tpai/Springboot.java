package com.grupo7.dsi.tpai;

import com.grupo7.dsi.tpai.service.*;
import com.grupo7.dsi.tpai.boundaries.*;
import com.grupo7.dsi.tpai.controllers.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot {

    public static void main(String[] args) {
        SpringApplication.run(Springboot.class, args);
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {};
    }
}


