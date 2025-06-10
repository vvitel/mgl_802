package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        AppCollection appCollection = new AppCollection();

        AppView view = new AppView();

        view.getBtnInstall().setOnAction(e -> {
            StandaloneApp app = new StandaloneApp("VS Code", false);
            InstallerFactory factory = new WindowsInstallerFactory();
            Installer installer = factory.createInstaller();
            installer.install(app);
            app.setInstalled(true);
            appCollection.addApp(app);
            System.out.println("App installed");
        });

        primaryStage.setTitle("App Manager");
        primaryStage.setScene(view.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
