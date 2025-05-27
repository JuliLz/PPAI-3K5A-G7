package com.grupo7.dsi.tpai.boundaries.utils;

import javafx.fxml.FXMLLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class SpringFXMLLoader {

    private final ApplicationContext context;

    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public <T> T load(String fxmlPath) throws IOException {
        try (InputStream is = getClass().getResourceAsStream(fxmlPath)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(context::getBean);
            return loader.load(is);
        }
    }
}