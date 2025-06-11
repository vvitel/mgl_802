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
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        ArrayList<IApplication> applications = new ArrayList<IApplication>();
        InstallerFactory installerFactory;
        if( System.getProperty("os.name").startsWith("Windows")) installerFactory = new WindowsInstallerFactory();
        else installerFactory = new LinuxInstallerFactory();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000"))
                .build();
        client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept((response) -> {
                    JSONObject jo = new JSONObject(response);
                    JSONArray apps = jo.getJSONArray("applications");
                    ArrayList<StandaloneApp> standaloneApps = new ArrayList<>();
                    for (int i = 0; i < apps.length(); i++) {
                        JSONObject app = apps.getJSONObject(i);
                        StandaloneApp standaloneApp = new StandaloneApp(app.getString("name"), app.getInt("size"),
                                false);
                        applications.add(standaloneApp);
                        standaloneApps.add(standaloneApp);
                    }
                    JSONArray collections = jo.getJSONArray("collections");
                    for (int i = 0; i < collections.length(); i++) {
                        JSONObject jsonCollection = collections.getJSONObject(i);
                        AppCollection collection = new AppCollection(jsonCollection.getString("name"));
                        JSONArray includedApps = jsonCollection.getJSONArray("applications");
                        for (int j = 0; j < includedApps.length(); j++) {
                            for (StandaloneApp stdApp : standaloneApps) {
                                if (stdApp.getName().equals(includedApps.getJSONObject(j).getString("name")))
                                    collection.addApp(stdApp);
                            }

                        }
                        applications.add(collection);
                    }
                    System.out.println(applications);
                    /*for (IApplication a : applications){
                        a.accept(new InstallVisitor(installerFactory));
                    }
                    System.out.println(applications);   */
                })
                .join();

        AppView view = new AppView();
        Installer installer = installerFactory.createInstaller();
        installer.addObserver(new InstallLogger());

        view.displayApplications(applications, installer);

        primaryStage.setTitle("App Manager");
        primaryStage.setScene(view.getScene());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
