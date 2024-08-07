package io.github.koresmosto.play;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cartesian.printQuadrant(new Point(5, 3));

        Cartesian.printQuadrant(new Point(-15, 3));
    }
}

record Point(int x, int y) {
}

class Cartesian {

    static void printQuadrant(Point p) {
        switch (p) {
            case Point(var x, var y) when x > 0 && y > 0 -> System.out.println("first");
            default -> System.out.println("other");
        }
    }
}