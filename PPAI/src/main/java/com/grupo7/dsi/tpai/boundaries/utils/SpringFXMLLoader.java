package com.grupo7.dsi.tpai.boundaries.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class SpringFXMLLoader {

    private final ApplicationContext ctx;
    private Object lastController;

    @Autowired
    public SpringFXMLLoader(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public Parent load(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        loader.setControllerFactory(clazz -> {
            Object controller = ctx.getBean(clazz);
            lastController = controller;
            return controller;
        });
        return loader.load();
    }

    @SuppressWarnings("unchecked")
    public <T> T getLastController(Class<T> type) {
        return (T) lastController;
    }
}