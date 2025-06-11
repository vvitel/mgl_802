package org.example;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.List;

public class AppView {
    private VBox root = new VBox(15);

    public VBox getRoot() {
        return root;
    }

    public Scene getScene() {
        return new Scene(root, 500, 600);
    }

    public void displayApplications(List<IApplication> apps, Installer installer) {
        root.getChildren().clear();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        for (IApplication app : apps) {
            if (app instanceof StandaloneApp sa) {
                VBox card = new VBox(10);
                card.setPadding(new Insets(10));
                card.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc; -fx-border-radius: 5; -fx-background-radius: 5;");
                card.setAlignment(Pos.CENTER_LEFT);

                Label nameLabel = new Label("📦 " + sa.getName());
                nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                Label sizeLabel = new Label("Size: " + sa.getSize() + " bytes");

                if (sa.isInstalled()) {
                    Label installedLabel = new Label("✅ Installed");
                    installedLabel.setStyle("-fx-text-fill: green;");
                    card.getChildren().addAll(nameLabel, sizeLabel, installedLabel);
                } else {
                    Button installBtn = new Button("Install");
                    ProgressBar progressBar = new ProgressBar();
                    progressBar.setPrefWidth(200);
                    progressBar.setVisible(false);

                    installBtn.setOnAction(e -> {
                        installBtn.setDisable(true);
                        progressBar.setVisible(true);

                        // Simulate progress with a short delay using a thread
                        new Thread(() -> {
                            try {
                                for (int i = 0; i <= 100; i += 5) {
                                    final double progress = i / 100.0;
                                    Platform.runLater(() -> progressBar.setProgress(progress));
                                    Thread.sleep(25);
                                }

                                Platform.runLater(() -> {
                                    installer.install(sa); // install the app
                                    displayApplications(apps, installer); // refresh the view
                                });
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }).start();
                    });

                    card.getChildren().addAll(nameLabel, sizeLabel, installBtn, progressBar);
                }

                root.getChildren().add(card);
            }
        }
    }
}
