package com.company;

public class Num extends Thread {
    private int number;
    private int divider;

    public Num(int number, int divider) {
        this.number = number;
        this.divider = divider;
    }

    @Override
    public void run() {
        int counter = 1;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) counter++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        this.setDivider(counter);
        System.out.println("The number can be divided by " + counter + " numbers");
    }

    public void setDivider(int divide) {
        this.divider = divide;
    }

    public int getDivider() {
        return divider;
    }

    @Override
    public String toString() {
        return "Number " + number + " has " + divider + "dividers";
    }
}
