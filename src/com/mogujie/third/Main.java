package com.mogujie.third;

import java.util.HashSet;
import java.util.Scanner;

/**
 * [编程题] 聊天
 * A和B是好友，他们经常在空闲时间聊天，A的空闲时间为[a1 ,b1 ],[a2 ,b2 ]..[ap ,bp ]。B的空闲时间是[c1 +t,d1 +t]..[cq +t,dq +t],
 * 这里t为B的起床时间。这些时间包括了边界点。B的起床时间为[l,r]的一个时刻。若一个起床时间能使两人在任意时刻聊天，那么这个时间就是合适的，问有多少个合适的起床时间？
 * <p>
 * 输入描述:
 * 第一行数据四个整数：p,q,l,r（1≤p,q≤50,0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai，bi(0≤aii+1>bi,ci+1>di
 * <p>
 * <p>
 * 输出描述:
 * 输出答案个数
 * <p>
 * 输入例子:
 * 2 3 0 20
 * 15 17
 * 23 26
 * 1 4
 * 7 11
 * 15 17
 * <p>
 * 输出例子:
 * 20
 * 输出描述:
 * 输出答案个数
 * <p>
 * 输入例子:
 * 2 3 0 20
 * 15 17
 * 23 26
 * 1 4
 * 7 11
 * 15 17
 * <p>
 * 输出例子:
 * 20
 */
public class Main {
    //2 3 0 20
    //    15 17
    //            23 26
    //            1 4
    //            7 11
    //            15 17
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int[][] a = new int[p][2];
            int[][] b = new int[q][2];
            for (int i = 0; i < p; i++) {
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
            }
            for (int i = 0; i < q; i++) {
                b[i][0] = in.nextInt();
                b[i][1] = in.nextInt();
            }
            HashSet<Integer> aSet = new HashSet<>();
            for (int i = 0; i < p; i++) {
                for (int j = a[i][0]; j <= a[i][1]; j++) {
                    aSet.add(j);
                }
            }
            int[] results = new int[r - l + 1];
            for (int i = l; i <= r; i++) {
                HashSet<Integer> bSet = new HashSet<>();
                for (int bIndex = 0; bIndex < q; bIndex++) {
                    for (int j = b[bIndex][0] + i; j <= b[bIndex][1] + i; j++) {
                        bSet.add(j);
                    }
                }
                for (Integer bNumber : bSet) {
                    if (aSet.contains(bNumber)) {
                        results[i - l] = 1;
                        break;
                    }
                }
            }
            int result = 0;
            //            System.out.println(Arrays.toString(results));
            for (int i : results) {
                if (i == 1) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
