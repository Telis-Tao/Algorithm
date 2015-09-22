package com.testforjob;

import java.util.Scanner;

/**
 * Created by taoxiaoqing on 15/9/20.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static String solution() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        double num = Integer.valueOf(inputs[0]);
        int count = Integer.valueOf(inputs[1]);
        double sum = num;
        while (--count > 0) {
            num = Math.pow(num, 0.5);
            sum += num;
        }
        return String.format("%.2f", sum);
    }
}
