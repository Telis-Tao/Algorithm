package com.testforjob.cal_ball;

import java.util.Scanner;

/**
 * Created by Telis on 2015/9/24.
 */
public class Main {
    private static final double PI = 3.1415927;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double radius = in.nextDouble();
            System.out.println(String.format("%.3f", 4 / 3.0 * PI * Math.pow(radius, 3)));
        }
    }
}
