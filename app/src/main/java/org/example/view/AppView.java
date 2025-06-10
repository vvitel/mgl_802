package org.example;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AppView {
    private Button btnInstall = new Button("Install");

    public VBox getRoot() {
        return new VBox(10, btnInstall);
    }

    public Button getBtnInstall() {
        return btnInstall;
    }

    public Scene getScene() {
        return new Scene(getRoot(), 300, 200);
    }
}
