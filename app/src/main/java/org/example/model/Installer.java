package org.example;

public interface Installer {
    void install(StandaloneApp app);
    void addObserver(AppInstallObserver observer);
    void removeObserver(AppInstallObserver observer);
}
