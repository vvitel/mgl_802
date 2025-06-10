package org.example;

public class LinuxInstaller implements Installer {
    @Override
    public void install(StandaloneApp app) {
            System.out.println("Installing Linux app: " + ((StandaloneApp) app).isInstalled());
            app.setInstalled(true);
            System.out.println("Installing Linux app: " + ((StandaloneApp) app).isInstalled());
    }
}
