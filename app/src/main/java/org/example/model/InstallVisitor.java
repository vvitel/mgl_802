package org.example;

public class InstallVisitor implements Visitor{

    Installer installer;

    public InstallVisitor(Installer installer){
        this.installer = installer;
    }

    public void visit(AppCollection app){
        for (IApplication application : app){
            application.accept(this);
        }
    }

    public void visit(StandaloneApp app){
        installer.install(app);
    }

}
