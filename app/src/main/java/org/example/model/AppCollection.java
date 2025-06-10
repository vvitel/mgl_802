package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppCollection implements IApplication, Iterable<IApplication> {
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
        StringBuilder sb = new StringBuilder(name+" content:[ ");
        for (IApplication app : apps) {
            sb.append(app.getName()+" ");
        };
        sb.append("] installed:"+this.isInstalled());
        return sb.toString();
    }

    public String getName(){
        return name;
    }

    public boolean isInstalled(){
        for (IApplication app : apps) {
            if(!app.isInstalled()) return false;
        }
        return true;
    }

    public Iterator<IApplication> iterator(){
        return apps.iterator();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

