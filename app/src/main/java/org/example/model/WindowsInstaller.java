package org.example;
import java.util.ArrayList;
import java.util.List;
public class WindowsInstaller implements Installer {
    private List<AppInstallObserver> observers = new ArrayList<>();
    @Override
    public void install(StandaloneApp app) {
        app.setInstalled(true);
        notifyObservers(app);
    }

    private void notifyObservers(IApplication app) {
        for (AppInstallObserver observer : observers) {
            observer.onAppInstalled(app);
        }
    }

    @Override
    public void addObserver(AppInstallObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(AppInstallObserver observer) {
        observers.remove(observer);
    }
}
