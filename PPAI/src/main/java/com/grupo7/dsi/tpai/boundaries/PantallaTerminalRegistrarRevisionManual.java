package com.grupo7.dsi.tpai.boundaries;

import com.grupo7.dsi.tpai.controllers.ControladorRevisionManual;
import com.grupo7.dsi.tpai.models.EventoSismico;

import java.util.List;

public class PantallaTerminalRegistrarRevisionManual {

    private ControladorRevisionManual controladorRevisionManual;

    public void opcRegistrarResultadosDeRevisionManual(ControladorRevisionManual controladorRevisionManual) {
        this.controladorRevisionManual = controladorRevisionManual;
        habilitarVentana();
    }

    public void habilitarVentana(){
        System.out.println("Pantalla de revision manual habilitada");
        List<EventoSismico> eventoSismicosFiltrados = controladorRevisionManual.registrarResultadoRevisionManual();
        if (eventoSismicosFiltrados == null) {
            System.out.println("No hay eventos sismicos pendientes de revision");
            return;
        }
        mostrarEventosSismicosPendientesDeRevision(eventoSismicosFiltrados);
    }

    public void mostrarEventosSismicosPendientesDeRevision(List<EventoSismico> eventosSismicos) {
        // Encabezado de tabla
        System.out.printf("%-20s %-20s %-20s %-10s %-10s %-10s %-10s %-10s%n",
                "Fecha/Hora Inicio", "Fecha/Hora Fin", "Origen", "Lat.Epi", "Lon.Epi", "Lat.Hipo", "Lon.Hipo", "Magnitud");
        System.out.println("-----------------------------------------------------------------------------------------------");

        // Filas de la tabla
        for (EventoSismico evento : eventosSismicos) {
            System.out.printf("%-20s %-20s %-20s %-10s %-10s %-10s %-10s %-10.2f%n",
                    evento.getFechaHoraOcurrencia(),
                    evento.getFechaHoraFin(),
                    evento.getOrigenGeneracion().getNombre(), // asumimos que OrigenDeGeneracion tiene getNombre()
                    evento.getLatitudEpicentro(),
                    evento.getLongitudEpicentro(),
                    evento.getLatitudHipocentro(),
                    evento.getLongitudHipocentro(),
                    evento.getValorMagnitud());
        }
    }

}
