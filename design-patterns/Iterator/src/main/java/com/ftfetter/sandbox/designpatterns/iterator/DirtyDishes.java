package com.ftfetter.sandbox.designpatterns.iterator;

public class DirtyDishes implements Dishes {
    public String dirtyDishesStack[];

    public DirtyDishes(String[] dirtyDishesStack) {
        this.dirtyDishesStack = dirtyDishesStack;
    }

    @Override
    public Iterator getIterator() {
        return new Cleaner();
    }

    public class Cleaner implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < dirtyDishesStack.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return String.format("Washing the %s", dirtyDishesStack[index++]);
            }
            return "You washed all the dishes. Congrats!";
        }
    }
}
