package com.grupo7.dsi.tpai.boundaries;

import com.grupo7.dsi.tpai.boundaries.utils.EventoSismicoDTO;
import com.grupo7.dsi.tpai.controllers.RegistrarRevisionManualController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
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
        habilitarVentana();
    }

    private void habilitarVentana() {
        colSeleccionar.setCellValueFactory(c -> c.getValue().seleccionadoProperty());
        colSeleccionar.setCellFactory(CheckBoxTableCell.forTableColumn(colSeleccionar));
        colFechaHora.setCellValueFactory(c -> c.getValue().fechaHoraProperty());
        colMagnitud.setCellValueFactory(c -> c.getValue().magnitudProperty());
        colLugarOrigen.setCellValueFactory(c -> c.getValue().lugarOrigenProperty());
    }

    public void mostrarEventosSismicosPendientesDeRevision(List<String> raw) {
        List<EventoSismicoDTO> dtos = raw.stream()
                .map(linea -> {
                    String[] p = linea.split(",", -1);
                    return new EventoSismicoDTO(
                            p.length>0 ? p[0] : "",  // fechaHora
                            p.length>1 ? p[1] : "",  // origenGeneracion
                            p.length>2 ? p[2] : "",  // magnitud
                            p.length>3 ? p[3] : ""   // lugarOrigen
                    );
                })
                .collect(Collectors.toList());

        ObservableList<EventoSismicoDTO> observableEventos = FXCollections.observableArrayList(dtos);
        tablaEventos.setItems(observableEventos);

        // Listener para forzar selección única
        for (EventoSismicoDTO evento : observableEventos) {
            evento.seleccionadoProperty().addListener((obs, old, neu) -> {
                if (neu) {
                    observableEventos.stream()
                            .filter(o -> o != evento)
                            .forEach(o -> o.seleccionadoProperty().set(false));
                }
            });
        }
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

        // ¡Y cerramos la ventana!
        Stage stage = (Stage) tablaEventos.getScene().getWindow();
        stage.close();
    }

    public void mostrarDatosEventoSismicoSeleccionado(List<String> datos) {
        // Nuevo diálgo como Stage modal
        Stage dialog = new Stage();
        dialog.setTitle("Detalle del Evento Sísmico");
        dialog.initModality(Modality.APPLICATION_MODAL);

        // GridPane con espaciado y padding
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(8);
        grid.setPadding(new Insets(20));

        // Encabezados de columnas
        Label headerKey = new Label("Propiedad");
        headerKey.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        Label headerValue = new Label("Valor");
        headerValue.setStyle("-fx-font-weight: bold; -fx-underline: true;");
        grid.add(headerKey, 0, 0);
        grid.add(headerValue, 1, 0);

        // Rellenar filas con cada par clave:valor
        for (int i = 0; i < datos.size(); i++) {
            String linea = datos.get(i);
            String[] parts = linea.split(":", 2);
            String clave = parts[0].replaceAll("([a-z])([A-Z])","$1 $2"); // camelCase → separado
            String valor = parts.length > 1 ? parts[1] : "";

            Label lblKey = new Label(clave);
            Label lblValue = new Label(valor);
            grid.add(lblKey, 0, i + 1);
            grid.add(lblValue, 1, i + 1);
        }

        // Botón de cerrar
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> dialog.close());
        HBox hb = new HBox(btnCerrar);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10, 0, 0, 0));

        // Contenedor principal
        VBox root = new VBox(grid, hb);
        root.setSpacing(5);

        dialog.setScene(new Scene(root));
        dialog.showAndWait();
    }

}