package com.example.tooltipexample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        GridPane grid;
        Scene scene;
        Label name, password, infoMsg;
        TextField nameField;
        PasswordField passwordField;
        Tooltip nameTooltip, passwordTooltip;
        Button acceptBtn, cancelBtn;

        // Creamos y configuramos el layout
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(20);

        name = new Label("Nombre: ");
        password = new Label("Contraseña: ");
        nameField = new TextField();
        passwordField = new PasswordField();

        // Creamos y asignamos los tooltips
        nameTooltip = new Tooltip();
        nameTooltip.setText("Introduce el nombre");
        nameTooltip.setShowDelay(Duration.seconds(0.3));

        passwordTooltip = new Tooltip();
        passwordTooltip.setText("Introduce la contraseña");
        passwordTooltip.setShowDelay(Duration.seconds(0.3));

        nameField.setTooltip(nameTooltip);
        passwordField.setTooltip(passwordTooltip);

        // Creamos el mensaje de salida, lo centramos y que ocupe las 2 columnas
        infoMsg = new Label();
        GridPane.setHalignment(infoMsg, HPos.CENTER);
        GridPane.setColumnSpan(infoMsg, 2);

        // Creamos los botones
        acceptBtn = new Button("Aceptar");
        acceptBtn.setOnAction(event -> {
            if (nameField.getText().equals("") || passwordField.getText().equals("")) {
                infoMsg.setText("¡Rellena todos los campos!");
            } else {
                nameField.setText("");
                passwordField.setText("");
                infoMsg.setText("¡Se han guardado tus datos!");
            }
        });

        cancelBtn = new Button("Cancelar");
        cancelBtn.setOnAction(event -> {
            nameField.setText("");
            passwordField.setText("");
            infoMsg.setText("");
        });
        GridPane.setHalignment(cancelBtn, HPos.CENTER);

        // Añadimos los nodos al GridPane
        grid.addRow(0, name, nameField);
        grid.addRow(1, password, passwordField);
        grid.addRow(2, acceptBtn, cancelBtn);
        grid.addRow(3, infoMsg);

        scene = new Scene(grid, 320, 240);
        stage.setTitle("Tooltip");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}