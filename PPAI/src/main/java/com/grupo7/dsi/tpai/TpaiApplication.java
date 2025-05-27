package com.grupo7.dsi.tpai;

import com.grupo7.dsi.tpai.service.*;
import com.grupo7.dsi.tpai.boundaries.*;
import com.grupo7.dsi.tpai.controllers.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TpaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpaiApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ControladorRevisionManual gestorCrudRevisionManual){
        return args -> {

            PantallaTerminalRegistrarRevisionManual pantallaTerminal = new PantallaTerminalRegistrarRevisionManual();

            pantallaTerminal.opcRegistrarResultadosDeRevisionManual(gestorCrudRevisionManual);


        };
    }

}


