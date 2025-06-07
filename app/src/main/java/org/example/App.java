package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{
    @Override
    public void start(Stage primaryStage) {
        IApplication chrome = new StandaloneApp("Google Chrome",true);
        IApplication vscode = new StandaloneApp("VS Code",false);
        AppCollection devTools = new AppCollection();
        devTools.addApp(vscode);

        AppCollection allApps = new AppCollection();
        allApps.addApp(chrome);
        allApps.addApp(devTools);


        Button btnInstall = new Button("Install");

        VBox root = new VBox(10, btnInstall);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("App Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
