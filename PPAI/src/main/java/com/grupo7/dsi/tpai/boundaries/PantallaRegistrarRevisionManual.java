package com.grupo7.dsi.tpai.boundaries;

import com.grupo7.dsi.tpai.boundaries.utils.EventoSismicoDTO;
import com.grupo7.dsi.tpai.controllers.RegistrarRevisionManualController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Component
public class PantallaRegistrarRevisionManual implements Initializable {

    @Autowired
    private RegistrarRevisionManualController gestor;

    @FXML private AnchorPane rootPane;  // Contenedor base definido en VistaRegistrarRevisionManual.fxml

    // ↓ Estos se inyectan al cargar la tabla ↓
    @FXML private TableView<EventoSismicoDTO> tablaEventos;
    @FXML private TableColumn<EventoSismicoDTO, Boolean> colSeleccionar;
    @FXML private TableColumn<EventoSismicoDTO, String>  colFechaHora;
    @FXML private TableColumn<EventoSismicoDTO, String>  colMagnitud;
    @FXML private TableColumn<EventoSismicoDTO, String>  colLugarOrigen;

    // ↓ Estos se inyectan al cargar el detalle ↓
    @FXML private Label lblFechaHoraOcurrencia;
    @FXML private Label lblOrigenGeneracion;
    @FXML private Label lblFechaHoraFin;
    @FXML private Label lblLatitudEpicentro;
    @FXML private Label lblLongitudEpicentro;
    @FXML private Label lblLatitudHipocentro;
    @FXML private Label lblLongitudHipocentro;
    @FXML private Label lblValorMagnitud;
    @FXML private Label lblMagnitudRichter;
    @FXML private Label lblClasificacionSismo;
    @FXML private Label lblAlcanceSismo;
    @FXML private Label lblEstadoActual;
    @FXML private Label lblAnalistaSupervisor;
    // …más Labels según tus campos de detalle…

    private Stage stage;

    @Override
    public void initialize(URL loc, ResourceBundle res) {
        // no hago nada: espero al optRegistrar…
    }

    public void optRegistrarResultadoDeRevisionManual() {
        habilitarVentana();
        gestor.registrarResultadoDeRevisionManual();
    }

    private void habilitarVentana() {
        if (stage == null) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/views/PantallaRegistrarRevisionManual.fxml")
                );
                loader.setControllerFactory(cls -> this);
                Parent root = loader.load();
                stage = new Stage();
                stage.setTitle("Registrar Revisión Manual");
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        stage.show();
    }

    public void mostrarEventosSismicosPendientesDeRevision(List<String> raws) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/VistaRegistrarRevisionManualTabla.fxml")
            );
            loader.setControllerFactory(cls -> this);
            AnchorPane tablaView = loader.load();

            rootPane.getChildren().setAll(tablaView);
            AnchorPane.setTopAnchor(tablaView, 0.0);
            AnchorPane.setBottomAnchor(tablaView, 0.0);
            AnchorPane.setLeftAnchor(tablaView, 0.0);
            AnchorPane.setRightAnchor(tablaView, 0.0);

            // 1) activa edición
            tablaEventos.setEditable(true);
            colSeleccionar.setEditable(true);

            // 2) configura las columnas
            colSeleccionar.setCellValueFactory(c -> c.getValue().seleccionadoProperty());
            colSeleccionar.setCellFactory(CheckBoxTableCell.forTableColumn(colSeleccionar));
            colFechaHora .setCellValueFactory(c -> c.getValue().fechaHoraProperty());
            colMagnitud .setCellValueFactory(c -> c.getValue().magnitudProperty());
            colLugarOrigen.setCellValueFactory(c -> c.getValue().lugarOrigenProperty());

            // 3) llena con datos
            ObservableList<EventoSismicoDTO> data = FXCollections.observableArrayList(
                    raws.stream().map(l -> {
                        String[] p = l.split(",", -1);
                        return new EventoSismicoDTO(
                                p.length>0?p[0]:"",
                                p.length>1?p[1]:"",
                                p.length>2?p[2]:"",
                                p.length>3?p[3]:""
                        );
                    }).collect(Collectors.toList())
            );
            tablaEventos.setItems(data);

            // 4) forzar sólo uno seleccionado
            data.forEach(e ->
                    e.seleccionadoProperty().addListener((o,old,n) -> {
                        if (n) data.stream()
                                .filter(x->x!=e)
                                .forEach(x->x.seleccionadoProperty().set(false));
                    })
            );

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void tomarSeleccionEventoSismico() {
        EventoSismicoDTO sel = tablaEventos.getItems().stream()
                .filter(EventoSismicoDTO::isSeleccionado)
                .findFirst().orElse(null);

        if (sel == null) {
            new Alert(Alert.AlertType.WARNING,
                    "Debe seleccionar un evento sísmico").showAndWait();
            return;
        }

        gestor.tomarSeleccionEventoSismico(
                sel.getFechaHora(), sel.getOrigenGeneracion()
        );
    }

    public void mostrarDatosEventoSismicoSeleccionado(List<String> datos) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/views/VistaRegistrarRevisionManualDetalleES.fxml")
            );
            loader.setControllerFactory(cls -> this);
            AnchorPane detalleView = loader.load();

            rootPane.getChildren().setAll(detalleView);
            AnchorPane.setTopAnchor(detalleView, 0.0);
            AnchorPane.setBottomAnchor(detalleView, 0.0);
            AnchorPane.setLeftAnchor(detalleView, 0.0);
            AnchorPane.setRightAnchor(detalleView, 0.0);

            // Esperar a que se inyecten los @FXML antes de usarlos
            javafx.application.Platform.runLater(() -> {
                datos.forEach(line -> {
                    String[] kv = line.split(":", 2);
                    if (kv.length < 2) return;

                    switch (kv[0]) {
                        case "fechaHoraOcurrencia":     lblFechaHoraOcurrencia.setText(kv[1]); break;
                        case "origenGeneracion":        lblOrigenGeneracion.setText(kv[1]); break;
                        case "fechaHoraFin":            lblFechaHoraFin.setText(kv[1]); break;
                        case "latitudEpicentro":        lblLatitudEpicentro.setText(kv[1]); break;
                        case "longitudEpicentro":       lblLongitudEpicentro.setText(kv[1]); break;
                        case "latitudHipocentro":       lblLatitudHipocentro.setText(kv[1]); break;
                        case "longitudHipocentro":      lblLongitudHipocentro.setText(kv[1]); break;
                        case "valorMagnitud":           lblValorMagnitud.setText(kv[1]); break;
                        case "magnitudRichter":         lblMagnitudRichter.setText(kv[1]); break;
                        case "clasificacionSismo":      lblClasificacionSismo.setText(kv[1]); break;
                        case "alcanceSismo":            lblAlcanceSismo.setText(kv[1]); break;
                        case "estadoActual":            lblEstadoActual.setText(kv[1]); break;
                        case "analistaSupervisor":      lblAnalistaSupervisor.setText(kv[1]); break;
                    }
                });
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
