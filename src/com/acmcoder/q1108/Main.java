package com.acmcoder.q1108;

import java.util.Scanner;

/**
 * Created by Telis on 2015/9/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int bigger = Math.max(a, b);
            int max = a * b;
            int answer = bigger;
            while (true) {
                if (answer % a == 0 && answer % b == 0) {
                    System.out.println(answer);
                    break;
                } else if (answer >= max) {
                    System.out.println(answer);
                    break;
                } else {
                    answer++;
                }
            }
        }
    }
}
