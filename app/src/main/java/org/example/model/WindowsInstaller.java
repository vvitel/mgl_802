package org.example;

public class WindowsInstaller implements Installer {
    @Override
    public void install(IApplication app) {
        if (app instanceof StandaloneApp sa) {
            System.out.println("Installing windows app: " + ((StandaloneApp) app).getInstalled());
            sa.setInstalled(true);
            System.out.println("Installing windows app: " + ((StandaloneApp) app).getInstalled());
        }
    }
}
