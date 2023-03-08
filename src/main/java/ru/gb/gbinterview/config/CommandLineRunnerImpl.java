package ru.gb.gbinterview.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.gb.gbinterview.model.Person;
import ru.gb.gbinterview.model.figures.Round;
import ru.gb.gbinterview.model.figures.Square;
import ru.gb.gbinterview.model.figures.Triangle;

import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Домашнее задание 1 Задача 1
        String firstName = "FirstName";
        Person person = new Person.Builder().addFirstName(firstName).build();
        System.out.println(person.getFirstName());

        // Домашнее задание 1 задача 3
        Round round = new Round("круг");
        double diameter = round.getDiameter(15.63);
        System.out.println(round.getName());

        Square square = new Square("квадрат");
        float squareSquare = square.getSquare(12.84F, 13.57F);

        Triangle triangle = new Triangle("треугольник");
        float angle = triangle.getAngle(40F, 120F);
    }
}
