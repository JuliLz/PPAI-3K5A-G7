package com.grupo7.dsi.tpai.boundaries;

import com.grupo7.dsi.tpai.Springboot;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VentanaPrincipal extends Application {

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(Springboot.class).run();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        springContext.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PantallaPrincipal.fxml"));
        loader.setControllerFactory(springContext::getBean);
        Parent root = loader.load();
        primaryStage.setTitle("Ventana Principal");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}


