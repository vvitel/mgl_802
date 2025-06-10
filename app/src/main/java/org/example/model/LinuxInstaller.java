package org.example;

public class LinuxInstaller implements Installer {
    @Override
    public void install(IApplication app) {
        if (app instanceof StandaloneApp sa) {
            System.out.println("Installing Linux app: " + ((StandaloneApp) app).getInstalled());
            sa.setInstalled(true);
            System.out.println("Installing Linux app: " + ((StandaloneApp) app).getInstalled());
        }
    }
}
