package com.mogujie.first;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by taoxiaoqing on 15/9/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int radius = in.nextInt();
            int sourceX = in.nextInt();
            int sourceY = in.nextInt();
            int targetX = in.nextInt();
            int targetY = in.nextInt();
            double distance = Math.pow(Math.pow(sourceX - targetX, 2) + Math.pow(sourceY - targetY, 2), 0.5);
            if (distance % (radius * 2) == 0) {
                System.out.println((int) distance / radius / 2);
            } else {
                int count = (int) (distance / radius / 2);
                double remain = distance - count * radius * 2;
                if (remain > radius && remain < 2 * radius) {
                    count++;
                } else {
                    count++;
                    count++;
                }
                System.out.println(count);
            }

        }
    }
}
