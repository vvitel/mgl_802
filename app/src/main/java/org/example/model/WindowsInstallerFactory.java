package org.example;

public class WindowsInstallerFactory implements InstallerFactory {
    @Override
    public Installer createInstaller() {
        return new WindowsInstaller();
    }
}
