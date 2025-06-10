package org.example;

public class WindowsInstaller implements Installer {
    @Override
    public void install(StandaloneApp app) {
            System.out.println("Installing windows app: " + ((StandaloneApp) app).isInstalled());
            app.setInstalled(true);
            System.out.println("Installing windows app: " + ((StandaloneApp) app).isInstalled());
    }
}
