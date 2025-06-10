package org.example;

public class StandaloneApp implements IApplication {
    private String name;
    private int size;
    private boolean installed;

    public StandaloneApp(String name, int size, boolean installed) {
        this.name = name;
        this.size = size;
        this.installed=installed;
    }

    public String getName() {
        return name;
    }

    public boolean getInstalled() {
        return installed;
    }

    public int getSize(){
        return size;
    }

    public void setName(String name) {
         this.name=name;
    }

    public void setInstalled(boolean installed) {
         this.installed= installed;
    }

    public void setSize(int size){
        this.size = size;
    }

    public String toString(){
        return name+" "+size+"bytes installed:"+installed;
    }
}
