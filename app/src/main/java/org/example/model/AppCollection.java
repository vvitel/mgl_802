package org.example;


import java.util.ArrayList;
import java.util.List;

public class AppCollection implements IApplication {
    private List<IApplication> apps = new ArrayList();
    private String name;

    public AppCollection(String name){
        this.name = name;
    }

    public void addApp(IApplication app) {
        apps.add(app);
    }

    public void removeApp(IApplication app) {
        apps.remove(app);
    }

    public String toString(){
        return name + apps;
    }
}

