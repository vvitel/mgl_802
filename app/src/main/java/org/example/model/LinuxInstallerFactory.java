package org.example;

public class LinuxInstallerFactory implements InstallerFactory {
    @Override
    public Installer createInstaller() {
        return new LinuxInstaller();
    }
}
