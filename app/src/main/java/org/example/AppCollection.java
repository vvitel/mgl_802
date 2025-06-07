package org.example;


import java.util.ArrayList;
import java.util.List;

public class AppCollection implements IApplication {
    private List<IApplication> apps = new ArrayList();

    public void addApp(IApplication app) {
        apps.add(app);
    }

    public void removeApp(IApplication app) {
        apps.remove(app);
    }
}

