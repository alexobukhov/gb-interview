package ru.gb.gbinterview.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.gb.gbinterview.model.Person;
import ru.gb.gbinterview.model.figures.Round;
import ru.gb.gbinterview.model.figures.Square;
import ru.gb.gbinterview.model.figures.Triangle;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Задание 1
        String firstName = "FirstName";
        Person person = new Person.Builder().addFirstName(firstName).build();

        // Задание 3
        Round round = new Round("круг");
        double diameter = round.getDiameter(15.63);

        Square square = new Square("квадрат");
        float squareSquare = square.getSquare(12.84F, 13.57F);

        Triangle triangle = new Triangle("треугольник");
        float angle = triangle.getAngle(40F, 120F);
    }
}
