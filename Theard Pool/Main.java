// Or Herbin 206092835
//Omri Millo 206093833

package com.company;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MATHEMATICIANS = 5;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(MATHEMATICIANS);

        System.out.print("Please enter a number.");
        int N = input.nextInt();

        Num[] numbers = new Num[N];

        for (int i = 1; i <= N; i++) {
            Runnable number = new Num(i, 0);
            numbers[i - 1] = (Num) number;
            executor.execute(number);
        }
        executor.shutdown();

        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int numIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i].getDivider() > numbers[i - 1].getDivider()) numIndex = i;
        }
        System.out.println("The num with the most dividers found is:" + numbers[numIndex].toString());
    }
}
