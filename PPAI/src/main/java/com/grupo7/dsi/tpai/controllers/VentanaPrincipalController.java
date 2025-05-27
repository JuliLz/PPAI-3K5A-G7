package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.boundaries.PantallaRegistrarRevisionManual;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentanaPrincipalController {

    @Autowired
    private PantallaRegistrarRevisionManual pantallaRegistrar;

    @FXML private Button btnRegistrarRevision;
    @FXML private Button btnSalir;

    @FXML
    private void handleRegistrarRevision() {
        // ① mensaje optRegistrarResultadoDeRevisionManual()
        pantallaRegistrar.optRegistrarResultadoDeRevisionManual();

        // ② cerramos la ventana actual
        Stage current = (Stage) btnRegistrarRevision.getScene().getWindow();
        current.close();
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }
}