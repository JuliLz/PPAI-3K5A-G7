package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.models.EstacionSismologica;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class GenerarSismogramaController {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LONGITUD_CODIGO = 10;
    private static final SecureRandom random = new SecureRandom();

    public List<String> generarSismograma(List<EstacionSismologica> estaciones) {
        List<String> datos = new ArrayList<>();

        for (EstacionSismologica estacion : estaciones) {
            String codigoAleatorio = generarCodigoAleatorio();
            String resultado = "Estación: " + estacion.getNombre() + " - CódigoURL: " + codigoAleatorio;
            datos.add(resultado);
        }

        return datos;
    }

    private String generarCodigoAleatorio() {
        StringBuilder sb = new StringBuilder(LONGITUD_CODIGO);
        for (int i = 0; i < LONGITUD_CODIGO; i++) {
            int index = random.nextInt(CARACTERES.length());
            sb.append(CARACTERES.charAt(index));
        }
        return sb.toString();
    }
}