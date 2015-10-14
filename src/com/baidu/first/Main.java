package com.baidu.first;


import java.util.*;

/**
 * 比大小
 * Time Limit: 3000/2000 MS (Java/Others) Memory Limit: 131072/65536 K (Java/Others)
 * Problem Description:
 * 现在有"abcdefghijkl”12个字符，将其所有的排列中按字典序排列，给出任意一种排列，说出这个排列在所有的排列中是第几小的？
 * 输入
 * 第一行有一个整数n（0<n<=10000）;
 * 随后有n行，每行是一个排列；
 * 输出
 * 输出一个整数m，占一行，m表示排列是第几位
 * <p>
 * 样例输入
 * 3
 * abcdefghijkl
 * hgebkflacdji
 * gfkedhjblcia
 * 样例输出
 * 1
 * 302715242
 * 260726926
 */
public class Main {
    private static final int COUNT = 479001600;
    private static HashMap<String, Integer> map = new HashMap<>(COUNT);

    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            while (count-- > 0) {
                String str = in.next();
                System.out.println(map.get(str));
            }
        }
    }

    private static void init() {
        int[] num = new int[12];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        result = new int[num.length];
        used = new int[num.length];
        permute(num, 0);
        System.out.println("init finish");
    }

    private static String intToString(int[] num) {
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append((char) ('a' + (i - 1)));
        }
        return sb.toString();
    }

    static int[] result;
    static int[] used;
    static int sCount;

    public static void permute(int[] num, int count) {
        if (count == num.length) {
            map.put(intToString(result), ++sCount);
        } else {
            for (int i = 0; i < num.length; i++) {
                if (used[i] == 0) {
                    used[i] = 1;
                    result[count] = num[i];
                    permute(num, count + 1);
                    used[i] = 0;
                }
            }
        }
    }
}
