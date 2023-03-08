package ru.gb.gbinterview.model.figures;

public class Round extends Figure implements Roundable {
    public Round(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "Имя изменено";
    }

    @Override
    public double getDiameter(double radius) {
        return Math.PI * Math.sqrt(radius);
    }
}
