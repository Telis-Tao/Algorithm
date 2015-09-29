package com.baidu.third;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 组合概率
 * Time Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
 * Problem Description:
 * 某生产零件的工厂为方便管理场内生产的零件种类，现将他们生产的零件从低等到高等零件排序，序号分别为1,
 * 2..n，已知该厂的任意几个低等的零件可以组合成更高等的零件，零件的序号代表了零件的等级，比如5号零件可以由1号和4号零件组合而成，也可以有2号和4号零件组合而成。
 * 现有一个序号为 x 的零件，它是由n个序号在[a,b]区间内的零件组合而成，求n个序号在[a,b]区间内的零件组合为 x 零件的概率
 * 输入
 * 一行输入四个整数依次为n，a，b，x，用空格分隔。数据规模和约定
 * 对于50%的数据，n≤5.
 * 对于100%的数据，n≤100,b≤100
 * 输出
 * 输出一行为组合为 x 零件的概率，小数点后保留四位小数
 * <p>
 * 样例输入
 * 2 1 3 4
 * 样例输出
 * 0.3333
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int x = in.nextInt();
            int space = b - a + 1;
            double totalCount = getResult(space, n) / getResult(n, n);
            result = new int[n];
            used = new int[b - a + 1];
            sCount = 0;
            getCount(a, b, x, n, 0);
            System.out.println(String.format("%.4f", sCount / totalCount));
        }


    }

    static int[] result;
    static int[] used;

    public static double getResult(int n, int count) {
        int result = 1;
        while (count-- > 0) {
            result *= n--;
        }
        return result;
    }

    static int sCount = 0;

    public static void getCount(int a, int b, int x, int n, int count) {
        if (count == n) {
            int sum = 0;
            for (int i = 0; i < result.length; i++) {
                sum += result[i];
            }
            if (sum >= x) {
                sCount++;
            }
        } else {
            for (int i = count == 0 ? 0 : result[count - 1]; i < b - a + 1; i++) {
                if (used[i] == 0) {
                    used[i] = 1;
                    result[count] = a + i;
                    getCount(a, b, x, n, count + 1);
                    used[i] = 0;
                }
            }
        }
    }

}
