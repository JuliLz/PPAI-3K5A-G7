package com.grupo7.dsi.tpai.boundaries;

import com.grupo7.dsi.tpai.dto.DetalleEventoSismicoDTO;
import com.grupo7.dsi.tpai.dto.EventoSismicoTablaDTO;
import com.grupo7.dsi.tpai.controllers.RegistrarRevisionManualController;
import javafx.application.Platform;
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
import javafx.scene.layout.VBox;
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
    @FXML private TableView<EventoSismicoTablaDTO> tablaEventos;
    @FXML private TableColumn<EventoSismicoTablaDTO, Boolean> colSeleccionar;
    @FXML private TableColumn<EventoSismicoTablaDTO, String>  colFechaHora;
    @FXML private TableColumn<EventoSismicoTablaDTO, String>  colMagnitud;
    @FXML private TableColumn<EventoSismicoTablaDTO, String>  colLugarOrigen;

    // Estos se inyectan al cargar el detalle
    @FXML private ListView<String> listDatosPrincipales;
    @FXML private VBox boxSeriesPorEstacion;
    @FXML private ListView<String> listCodigosSismograma;

    @FXML private TextField txtMagnitudNumero;
    @FXML private TextField txtMagnitudDescripcion;
    @FXML private TextField txtAlcanceNombre;
    @FXML private TextField txtAlcanceDescripcion;
    @FXML private TextField txtOrigenNombre;
    @FXML private TextField txtOrigenDescripcion;

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
        // Si no hay datos, mostrar un aviso y no cargar la tabla
        if (raws == null || raws.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "No hay eventos sísmicos pendientes de revisión.").showAndWait();
            cerrarVentana();
            return;
        }

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
            colFechaHora.setCellValueFactory(c -> c.getValue().fechaHoraProperty());
            colMagnitud.setCellValueFactory(c -> c.getValue().magnitudProperty());
            colLugarOrigen.setCellValueFactory(c -> c.getValue().lugarOrigenProperty());

            // 3) llena con datos
            ObservableList<EventoSismicoTablaDTO> data = FXCollections.observableArrayList(
                    raws.stream().map(l -> {
                        String[] p = l.split(",", -1);
                        return new EventoSismicoTablaDTO(
                                p.length > 0 ? p[0] : "",
                                p.length > 1 ? p[1] : "",
                                p.length > 2 ? p[2] : "",
                                p.length > 3 ? p[3] : ""
                        );
                    }).collect(Collectors.toList())
            );
            tablaEventos.setItems(data);

            // 4) forzar sólo uno seleccionado
            data.forEach(e ->
                    e.seleccionadoProperty().addListener((o, old, n) -> {
                        if (n) {
                            data.stream()
                                    .filter(x -> x != e)
                                    .forEach(x -> x.seleccionadoProperty().set(false));
                        }
                    })
            );

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void tomarSeleccionEventoSismico() {
        EventoSismicoTablaDTO sel = tablaEventos.getItems().stream()
                .filter(EventoSismicoTablaDTO::isSeleccionado)
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

    public void mostrarDatosEventoSismicoSeleccionado(DetalleEventoSismicoDTO dto) {
        if (dto == null) {
            new Alert(Alert.AlertType.WARNING, "No hay evento sísmico seleccionado.").showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/VistaRegistrarRevisionManualDetalleES.fxml")); // ✅ acá estaba el problema
            loader.setControllerFactory(cls -> this); // mantenemos el mismo controller
            AnchorPane detalleView = loader.load();

            rootPane.getChildren().setAll(detalleView);
            AnchorPane.setTopAnchor(detalleView, 0.0);
            AnchorPane.setBottomAnchor(detalleView, 0.0);
            AnchorPane.setLeftAnchor(detalleView, 0.0);
            AnchorPane.setRightAnchor(detalleView, 0.0);

            Platform.runLater(() -> {
                listDatosPrincipales.getItems().setAll(dto.getDatosPrincipales());

                boxSeriesPorEstacion.getChildren().clear();
                dto.getSeriesTemporalesPorEstacion().forEach((estacion, series) -> {
                    Label lblEstacion = new Label("Estación: " + estacion);
                    VBox vboxSeries = new VBox(5);
                    series.forEach(s -> vboxSeries.getChildren().add(new Label(" • " + s)));

                    VBox seccion = new VBox(lblEstacion, vboxSeries);
                    seccion.setSpacing(5);
                    seccion.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10; -fx-background-radius: 5;");
                    boxSeriesPorEstacion.getChildren().add(seccion);
                });

                listCodigosSismograma.getItems().setAll(dto.getCodigosSismograma());
            });

        } catch (IOException ex) {
            ex.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al cargar la vista de detalle: " + ex.getMessage()).showAndWait();
        }
    }

    @FXML
    private void continuarCerrarDetalleEvento() {
        solicitarVisualizacionMapa();
    }

    private void solicitarVisualizacionMapa() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Desea ver el mapa del evento sísmico?",
                ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(null);
        alert.setTitle("Visualización de Mapa");

        alert.showAndWait().ifPresent(response -> {
            tomarSeleccionVisualizacionMapa(response == ButtonType.YES);
        });
    }

    private void tomarSeleccionVisualizacionMapa(boolean verMapa) {
        if (verMapa) {
            // Cargar la vista del mapa (un caso alternativo)
            cargarVista("/views/VistaRegistrarRevisionManualMapa.fxml");
        } else {
            // Cerrar la vista
            gestor.modificarDatosEventoSismico(); //
        }
    }

    // Caso alternativo del CU no contemplado en el diagrama de secuencia
    public void cargarVista(String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            loader.setControllerFactory(cls -> this); // Si el controlador actual contiene la lógica
            AnchorPane nuevaVista = loader.load();

            rootPane.getChildren().setAll(nuevaVista);
            AnchorPane.setTopAnchor(nuevaVista, 0.0);
            AnchorPane.setBottomAnchor(nuevaVista, 0.0);
            AnchorPane.setLeftAnchor(nuevaVista, 0.0);
            AnchorPane.setRightAnchor(nuevaVista, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error al cargar la vista: " + rutaFXML).showAndWait();
        }
    }

    // Abre la vista para modificar los datos del evento sísmico seleccionado y permite al usuario continuar con o sin modificaciones.
    public void solicitarModificacionDeDatos(List<String> datosActuales) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VistaRegistrarRevisionManualModificacionES.fxml"));
            loader.setControllerFactory(cls -> this);
            AnchorPane vista = loader.load();

            rootPane.getChildren().setAll(vista);
            AnchorPane.setTopAnchor(vista, 0.0);
            AnchorPane.setBottomAnchor(vista, 0.0);
            AnchorPane.setLeftAnchor(vista, 0.0);
            AnchorPane.setRightAnchor(vista, 0.0);

            // Cargar los datos actuales desglosando cada línea
            if (datosActuales.size() >= 3) {
                // Magnitud: 5.6 Moderado
                String[] magnitud = datosActuales.get(0).replace("Magnitud: ", "").split(" ", 2);
                txtMagnitudNumero.setText(magnitud[0]);
                txtMagnitudDescripcion.setText(magnitud.length > 1 ? magnitud[1] : "");

                // Alcance: Local - Se sintió en zona urbana
                String[] alcance = datosActuales.get(1).replace("Alcance: ", "").split(" - ", 2);
                txtAlcanceNombre.setText(alcance[0]);
                txtAlcanceDescripcion.setText(alcance.length > 1 ? alcance[1] : "");

                // Origen de generación: Tectónico - Movimiento de placas
                String[] origen = datosActuales.get(2).replace("Origen de generación: ", "").split(" - ", 2);
                txtOrigenNombre.setText(origen[0]);
                txtOrigenDescripcion.setText(origen.length > 1 ? origen[1] : "");
            }

        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "No se pudo cargar el formulario de modificación.").showAndWait();
        }
    }

    @FXML
    private void tomarSeleccionModificacionDeDatos(){
        // No se modificaron los datos, continua el caso de uso
        gestor.continuarSinModificarDatos();
    }

    public void solicitarAccionFinalRevision() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Acción Final");
        alert.setHeaderText("¿Qué desea hacer con el evento sísmico?");
        alert.setContentText("Elegí una acción final:");

        ButtonType btnConfirmar = new ButtonType("✅ Confirmar");
        ButtonType btnRechazar = new ButtonType("❌ Rechazar");
        ButtonType btnRevisarExperto = new ButtonType("Solicitar a experto");

        alert.getButtonTypes().setAll(btnConfirmar, btnRechazar, btnRevisarExperto);

                alert.showAndWait().ifPresent(respuesta -> {
                    if (respuesta == btnConfirmar) {
                        // Lógica para confirmar el evento sísmico
                        // gestor.tomarSeleccionConfirmarEvento();
                    } else if (respuesta == btnRechazar) {
                        gestor.tomarSeleccionRechazarEvento();
                    } else if (respuesta == btnRevisarExperto) {
                // Lógica para solicitar revisión a un experto
            }
        });
    }

    public void cerrarVentana(){
        // Cierra la ventana de registro de revisión manual
        if (stage != null) {
            stage.close();
        }
    }

}
