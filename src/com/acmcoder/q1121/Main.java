package com.acmcoder.q1121;

import java.util.Scanner;

/**
 * Created by Telis on 2015/9/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int number = in.nextInt();
            int result = (int) ((1 + number) / 2.0 * number);
            System.out.println(result);
            System.out.println();
        }
    }
}
