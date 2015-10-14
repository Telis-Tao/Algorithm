package com.liebao.second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Telis on 2015/10/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            String[] strs = new String[count];
            for (int i = 0; i < strs.length; i++) {
                strs[i] = in.next();
            }
            for (int i = 0; i < strs.length; i++) {
                System.out.println(deleteString(strs[i]));
            }

        }
//        System.out.println(deleteString("aaaabbAacb"));
//        System.out.println(deleteString("AA"));

    }

    private static String deleteString(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        sb.append(str.charAt(0));
        set.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                sb.append(str.charAt(i));
                set.add(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
