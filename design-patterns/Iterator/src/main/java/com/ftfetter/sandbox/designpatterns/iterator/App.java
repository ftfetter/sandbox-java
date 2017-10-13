package com.ftfetter.sandbox.designpatterns.iterator;

public class App {

    public static void main(String[] args) {

        String[] dirtyDishesStack = {"Spoon", "Fork", "Plate", "Knife"};
        Dishes dirtyDishes = new DirtyDishes(dirtyDishesStack);
        Iterator cleaner = dirtyDishes.getIterator();

        while (cleaner.hasNext()) {
            String message = (String) cleaner.next();
            System.out.println(message);
        }
        System.out.println((String) cleaner.next());
    }
}
