package ru.gb.gbinterview.model.figures;

public class Triangle extends Figure implements Triangable {

    public Triangle(String name) {
        super(name);
    }

    @Override
    public float getAngle(float angleOne, float angleTwo) {
        return 180 - angleOne - angleTwo;
    }
}
