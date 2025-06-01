package com.grupo7.dsi.tpai.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetalleEventoSismicoDTO {

    private List<String> datosPrincipales = new ArrayList<>();
    private Map<String, List<String>> seriesTemporalesPorEstacion = new HashMap<>();
    private List<String> codigosSismograma = new ArrayList<>();

    public List<String> getDatosPrincipales() {
        return datosPrincipales;
    }

    public void setDatosPrincipales(List<String> datosPrincipales) {
        this.datosPrincipales = datosPrincipales;
    }

    public Map<String, List<String>> getSeriesTemporalesPorEstacion() {
        return seriesTemporalesPorEstacion;
    }

    public void setSeriesTemporalesPorEstacion(Map<String, List<String>> seriesTemporalesPorEstacion) {
        this.seriesTemporalesPorEstacion = seriesTemporalesPorEstacion;
    }

    public List<String> getCodigosSismograma() {
        return codigosSismograma;
    }

    public void setCodigosSismograma(List<String> codigosSismograma) {
        this.codigosSismograma = codigosSismograma;
    }
}