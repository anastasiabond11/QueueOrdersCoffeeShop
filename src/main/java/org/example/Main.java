package org.example;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.add("Masha");
        board.add("Andrej");
        board.add("Max");
        board.add("Sasha");

        board.draw();

        board.deliver();
        board.draw();

        board.deliver(33);
        board.draw();
    }
}
