package org.example;

public class InstallLogger implements AppInstallObserver {
    @Override
    public void onAppInstalled(IApplication app) {
            System.out.println("Observer: App installed -> " + app.getName());
    }
}
