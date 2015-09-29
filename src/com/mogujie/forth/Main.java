package com.mogujie.forth;

import java.util.Scanner;

/**
 * [编程题] 投篮游戏
 * 有一个投篮游戏。球场有p个篮筐，编号为0，1...，p-1。每个篮筐下有个袋子，每个袋子最多装一个篮球。有n个篮球，每个球编号xi 。规则是将数字为xi 的篮球投到xi
 * 除p的余数为编号的袋里。若袋里已有篮球则球弹出游戏结束输出i，否则重复至所有球都投完。输出-1。问游戏最终的输出是什么？
 * <p>
 * 输入描述:
 * 第一行两个整数p,n（2≤p,n≤300)。p为篮筐数，n为篮球数。接着n行为篮球上的数字xi(0≤xi≤1e9)
 * <p>
 * <p>
 * 输出描述:
 * 输出游戏的结果
 * <p>
 * 输入例子:
 * 10 5
 * 0
 * 21
 * 53
 * 41
 * 53
 * <p>
 * 输出例子:
 * 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int basketNum = in.nextInt();
            int ballNum = in.nextInt();
            int[] baskets = new int[basketNum];
            int[] shoots = new int[ballNum];
            boolean isInterrupted = false;
            for (int i = 0; i < ballNum; i++) {
                int shootNum = in.nextInt();
                shoots[i] = shootNum % basketNum;
            }
            for (int i = 0; i < ballNum; i++) {
                int shootNum = shoots[i];
                if (baskets[shootNum] == 1) {
                    System.out.println(i + 1);
                    isInterrupted = true;
                    break;
                } else {
                    baskets[shootNum] = 1;
                }
            }
            if (!isInterrupted) {
                System.out.println(-1);
            }
        }
    }
}
