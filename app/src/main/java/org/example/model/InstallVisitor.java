package org.example;

public class InstallVisitor implements Visitor{

    InstallerFactory installerFactory;

    public InstallVisitor(InstallerFactory installerFactory){
        this.installerFactory = installerFactory;
    }

    public void visit(AppCollection app){
        for (IApplication application : app){
            application.accept(new InstallVisitor(installerFactory));
        }
    }

    public void visit(StandaloneApp app){
        installerFactory.createInstaller().install(app);
    }

}
