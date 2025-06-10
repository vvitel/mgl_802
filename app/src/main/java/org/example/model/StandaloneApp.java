package org.example;

public class StandaloneApp implements IApplication {
    private String name;
    private boolean installed;

    public StandaloneApp(String name, boolean installed) {
        this.name = name;
        this.installed=installed;
    }

    public String getName() {
        return name;
    }

    public boolean getInstalled() {
        return installed;
    }

    public void setName(String name) {
         this.name=name;
    }

    public void setInstalled(boolean installed) {
         this.installed= installed;
    }
}
