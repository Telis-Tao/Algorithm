package com.testforjob.common_number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by taoxiaoqing on 15/9/21.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean finished = true;
        HashSet<Long> first = null;
        HashSet<Long> second = null;
        HashSet<Long> third = null;
        HashSet<Long> current = null;
        long index = 0;
        long length = 0;
        while (in.hasNext()) {
            String str = in.nextLine();
            if (finished) {
                length = Long.valueOf(str);
                if (first == null) {
                    first = new HashSet<Long>();
                    current = first;
                } else if (second == null) {
                    second = new HashSet<Long>();
                    current = second;
                } else if (third == null) {
                    third = new HashSet<Long>();
                    current = third;
                } else {
                    break;
                }
                finished = false;
            } else {
                long number = Long.valueOf(str);
                current.add(number);
                index++;
                if (index >= length) {
                    finished = true;
                    index = 0;
                    length = 0;
                    if (first != null && second != null && third != null) {
                        break;
                    }
                }
            }
        }
        //        System.out.println(first);
        //        System.out.println(second);
        //        System.out.println(third);
        ArrayList<Long> result = new ArrayList<Long>();
        for (Long integer : first) {
            if (second.contains(integer) && third.contains(integer)) {
                result.add(integer);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Long integer : result) {
            sb.append(integer).append(" ");
        }
        if (result.isEmpty()) {
            System.out.println(" ");
        } else {
            System.out.println(sb.toString().trim());
        }
    }
}
