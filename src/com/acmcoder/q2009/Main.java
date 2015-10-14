package com.acmcoder.q2009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            double base = in.nextInt();
            int count = in.nextInt();
            double sum = base;
            while (--count > 0) {
                base = Math.sqrt(base);
                sum += base;
            }
            System.out.println(String.format("%.2f", sum));
        }
    }

}

