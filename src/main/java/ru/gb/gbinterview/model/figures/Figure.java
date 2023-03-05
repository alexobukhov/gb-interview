package ru.gb.gbinterview.model.figures;

public abstract class Figure {

    String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
