package org.example;

public interface IApplication {
    public boolean isInstalled();

    public String getName();

    public String getSize();

    public void accept(Visitor v);
}
