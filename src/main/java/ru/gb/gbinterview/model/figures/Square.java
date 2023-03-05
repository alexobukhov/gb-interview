package ru.gb.gbinterview.model.figures;

public class Square extends Figure implements Squarable {

    public Square(String name) {
        super(name);
    }

    @Override
    public float getSquare(float height, float width) {
        return height * width;
    }
}
