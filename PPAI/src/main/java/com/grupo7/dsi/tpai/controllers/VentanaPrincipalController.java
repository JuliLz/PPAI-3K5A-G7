package com.grupo7.dsi.tpai.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentanaPrincipalController {

    @Autowired
    private RegistrarRevisionManualController gestorRevisionManual;

    @FXML
    private Button btnRegistrarRevision;

    @FXML
    private Button btnSalir;

    @FXML
    private void handleRegistrarRevision() {
        // ① Delegamos al gestor: él cargará el FXML, guardará la boundary y volcará los datos
        gestorRevisionManual.registrarResultadoRevisionManual();

        // ② Cerramos la ventana actual
        Stage current = (Stage) btnRegistrarRevision.getScene().getWindow();
        current.close();
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }
}