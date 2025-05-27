package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.boundaries.PantallaRegistrarRevisionManual;
import com.grupo7.dsi.tpai.models.EventoSismico;
import com.grupo7.dsi.tpai.service.EventoSismicoService;
import jakarta.annotation.PostConstruct;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegistrarRevisionManualController {

    @Autowired
    private ApplicationContext springContext;

    private PantallaRegistrarRevisionManual pantallaRegistrarRevisionManual;

    private final EventoSismicoService eventoSismicoService;
    private List<EventoSismico> eventosSismicosBDD;

    private EventoSismico eventosSismicoSeleccionado;

    @Autowired
    public RegistrarRevisionManualController(EventoSismicoService eventoSismicoService) {
        this.eventoSismicoService = eventoSismicoService;
    }

    @PostConstruct
    private void init() {
        this.eventosSismicosBDD = eventoSismicoService.findAll();
    }

    public void registrarResultadoRevisionManual(){
        List<String> eventosPendientesRevision = buscarEventosSismicosPendientesRevision();
        mostrarPantallaRevisionManual(eventosPendientesRevision);
    }

    public List<String> buscarEventosSismicosPendientesRevision() {
        //Buscar los eventos sismicos pendientes de revisión
        List<EventoSismico> eventosPendientes = new ArrayList<>();
        for (EventoSismico eventoBDD : eventosSismicosBDD) {
            if (eventoBDD.estaPendienteRevision()){
                eventosPendientes.add(eventoBDD);
            }
        }

        // Filtrar por fecha y hora de ocurrencia
        eventosPendientes = filtrarPorFechayHoraDeOcurrencia(eventosPendientes);

        // Devolver los eventos para mostrar en la pantalla
        return eventosPendientes.stream()
                .map(evento -> evento.getFechaHoraOcurrencia() + "," +
                        evento.getOrigenGeneracion().getNombre() + "," +
                        evento.getMagnitud().getNumero() + "," +
                        evento.getOrigenGeneracion().getNombre())
                .collect(Collectors.toList());
    }

    private List<EventoSismico> filtrarPorFechayHoraDeOcurrencia(List<EventoSismico> eventos) {
        return eventos.stream()
                .sorted(Comparator.comparing(EventoSismico::getFechaHoraOcurrencia))
                .collect(Collectors.toList());
    }

    public void mostrarPantallaRevisionManual(List<String> eventosPendientesRevision) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/PantallaRegistrarRevisionManual.fxml")
            );
            loader.setControllerFactory(springContext::getBean);
            Parent root = loader.load();

            // guardo la instancia del controller-boundary
            pantallaRegistrarRevisionManual = loader.getController();

            // muestro la ventana
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registrar Revisión Manual");
            stage.show();

            // justo después, pido los raw y los paso a la boundary
            List<String> raw = eventosPendientesRevision;
            pantallaRegistrarRevisionManual.mostrarEventosSismicosPendientesDeRevision(raw);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tomarSeleccionEventoSismico(String fechaHoraStr, String nombreOrigen){
        LocalDateTime fechaHora;
        try {
            fechaHora = LocalDateTime.parse(fechaHoraStr); //
        } catch (Exception e) {
            System.out.println("Error al convertir fechaHoraStr: " + e.getMessage());
            return;
        }

        for (EventoSismico evento : eventosSismicosBDD) {
            if (evento.getFechaHoraOcurrencia().equals(fechaHora)
                    && evento.getOrigenGeneracion().getNombre().equals(nombreOrigen)) {
                this.eventosSismicoSeleccionado = evento;
                System.out.println("Evento seleccionado: " + eventosSismicoSeleccionado);
                break;
            }
        }
        List<String> datosEventoSismicoSeleccionado = buscarDatosEventoSismicoSeleccionado();
        pantallaRegistrarRevisionManual.mostrarDatosEventoSismicoSeleccionado(datosEventoSismicoSeleccionado);
    }

    public List<String> buscarDatosEventoSismicoSeleccionado() {
        if (eventosSismicoSeleccionado == null) {
            return Collections.emptyList();
        }

        List<String> datos = new ArrayList<>();
        datos.add("FechaHoraOcurrencia:" + eventosSismicoSeleccionado.getFechaHoraOcurrencia());
        datos.add("OrigenGeneracion:"     + eventosSismicoSeleccionado.getOrigenGeneracion().getNombre());
        datos.add("FechaHoraFin:"         + (eventosSismicoSeleccionado.getFechaHoraFin() != null
                ? eventosSismicoSeleccionado.getFechaHoraFin()
                : ""));
        datos.add("LatitudEpicentro:"     + eventosSismicoSeleccionado.getLatitudEpicentro());
        datos.add("LongitudEpicentro:"    + eventosSismicoSeleccionado.getLongitudEpicentro());
        datos.add("LatitudHipocentro:"    + eventosSismicoSeleccionado.getLatitudHipocentro());
        datos.add("LongitudHipocentro:"   + eventosSismicoSeleccionado.getLongitudHipocentro());
        datos.add("ValorMagnitud:"        + eventosSismicoSeleccionado.getValorMagnitud());
        datos.add("MagnitudRichter:"      + eventosSismicoSeleccionado.getMagnitud().getNumero());
        datos.add("ClasificacionSismo:"   + eventosSismicoSeleccionado.getClasificacion().getNombre());
        datos.add("AlcanceSismo:"         + eventosSismicoSeleccionado.getAlcanceSismo().getNombre());
        datos.add("EstadoActual:"         + eventosSismicoSeleccionado.getEstadoActual().getNombre());
        if (eventosSismicoSeleccionado.getAnalistaSupervisor() != null) {
            datos.add("AnalistaSupervisor:"
                    + eventosSismicoSeleccionado.getAnalistaSupervisor().getNombre()
                    + " (Legajo " + eventosSismicoSeleccionado.getAnalistaSupervisor().getId() + ")");
        } else {
            datos.add("AnalistaSupervisor:N/A");
        }

        // Si quisieras, podrías agregar cambios de estado o serie temporal también…
        return datos;
    }
}