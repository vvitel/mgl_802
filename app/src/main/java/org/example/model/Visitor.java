package org.example;

public interface Visitor {
    public void visit(AppCollection app);
    public void visit(StandaloneApp app);
}
