package com.mogujie.second;

import java.util.Scanner;

/**
 * [编程题] 最大间隔
 * 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？
 * <p>
 * 输入描述:
 * 第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
 * <p>
 * <p>
 * 输出描述:
 * 输出答案。
 * <p>
 * 输入例子:
 * 5
 * 1 2 3 7 8
 * <p>
 * 输出例子:
 * 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            final int count = in.nextInt();
            final int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = in.nextInt();
            }
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < count - 1; i++) {
                int maxDistance = Integer.MIN_VALUE;
                int formerPosition = 0;
                for (int j = 1; j < count; j++) {
                    if (i == j) {
                        continue;
                    } else {
                        int distance = nums[j] - nums[formerPosition];
                        if (distance > maxDistance) {
                            maxDistance = distance;
                        }
                        formerPosition = j;
                    }
                }
                if (result > maxDistance) {
                    result = maxDistance;
                }
            }
            System.out.println(result);
        }
    }
}
