package com.grupo7.dsi.tpai.controllers;

import com.grupo7.dsi.tpai.boundaries.PantallaRegistrarRevisionManual;
import com.grupo7.dsi.tpai.boundaries.SpringFXMLLoader;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

@Component
public class VentanaPrincipalController {

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @FXML
    private Button btnRegistrarRevision;

    @FXML
    private Button btnSalir;

    @FXML
    private void handleRegistrarRevision() {
        try {
            // Carga la vista y el controlador como bean de Spring
            AnchorPane newRoot = springFXMLLoader.load("/views/PantallaRegistrarRevisionManual.fxml");

            // Abrimos en una nueva ventana
            Stage stage = new Stage();
            stage.setTitle("Registrar Revisión Manual");
            stage.setScene(new Scene(newRoot));
            stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("/views/iconoCodeChilli.png")));
            stage.show();

            // Cerramos la ventana actual
            Stage current = (Stage) btnRegistrarRevision.getScene().getWindow();
            current.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }
}
