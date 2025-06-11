package org.example;

public class InstallLogger implements AppInstallObserver {
    @Override
    public void onAppInstalled(IApplication app) {
        if (app instanceof StandaloneApp sa) {
            System.out.println("Observer: App installed -> " + sa.getName());
        }
    }
}
