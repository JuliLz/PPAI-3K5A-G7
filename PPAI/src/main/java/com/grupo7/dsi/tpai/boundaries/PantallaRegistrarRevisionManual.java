package com.grupo7.dsi.tpai.boundaries;

import com.grupo7.dsi.tpai.controllers.RegistrarRevisionManualController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Component
public class PantallaRegistrarRevisionManual implements Initializable {

    @FXML private TableView<EventoSismicoDTO> tablaEventos;
    @FXML private TableColumn<EventoSismicoDTO, Boolean> colSeleccionar;
    @FXML private TableColumn<EventoSismicoDTO, String>  colFechaHora;
    @FXML private TableColumn<EventoSismicoDTO, String>  colMagnitud;
    @FXML private TableColumn<EventoSismicoDTO, String>  colLugarOrigen;

    @Autowired
    private RegistrarRevisionManualController gestorRegistrarRevisionManual;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        habilitarPantalla();

        List<EventoSismicoDTO> eventos = gestorRegistrarRevisionManual
                .buscarEventosSismicosPendientesRevision()
                .stream()
                .map(linea -> {
                    String[] partes = linea.split(",", -1);
                    return new EventoSismicoDTO(
                            partes.length > 0 ? partes[0] : "",
                            partes.length > 1 ? partes[1] : "",
                            partes.length > 2 ? partes[2] : "",
                            partes.length > 3 ? partes[3] : ""
                    );
                })
                .collect(Collectors.toList());

        ObservableList<EventoSismicoDTO> observableEventos = FXCollections.observableArrayList(eventos);
        tablaEventos.setItems(observableEventos);

        // 🔁 Listener para permitir solo un seleccionado
        for (EventoSismicoDTO evento : observableEventos) {
            evento.seleccionadoProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    for (EventoSismicoDTO otro : observableEventos) {
                        if (otro != evento) {
                            otro.seleccionadoProperty().set(false);
                        }
                    }
                }
            });
        }
    }

    private void habilitarPantalla() {
        colSeleccionar.setCellValueFactory(c -> c.getValue().seleccionadoProperty());
        colSeleccionar.setCellFactory(CheckBoxTableCell.forTableColumn(colSeleccionar));
        colFechaHora.setCellValueFactory(c -> c.getValue().fechaHoraProperty());
        colMagnitud.setCellValueFactory(c -> c.getValue().magnitudProperty());
        colLugarOrigen.setCellValueFactory(c -> c.getValue().lugarOrigenProperty());
    }

    @FXML
    private void tomarSeleccionEventoSismico() {
        EventoSismicoDTO seleccionado = tablaEventos.getItems().stream()
                .filter(EventoSismicoDTO::isSeleccionado)
                .findFirst()
                .orElse(null);

        if (seleccionado == null) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Selección requerida");
            alerta.setHeaderText(null);
            alerta.setContentText("Debe seleccionar un evento sísmico para continuar.");
            alerta.showAndWait();
            return;
        }

        gestorRegistrarRevisionManual.tomarSeleccionEventoSismico(
                seleccionado.getFechaHora(),
                seleccionado.getOrigenGeneracion()
        );
    }
}