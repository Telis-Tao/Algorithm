package com.baidu.second;

import java.util.Scanner;

/**
 * ime Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
 * Problem Description:
 * 度度熊很想到外面的世界看看，于是收拾行装准备旅行。背了一个大竹筐，竹筐里装满了路上吃的，这些吃的够它走N
 * 公里。为了规划路线，它查看了地图，沿途中有若干个村庄，在这些村庄它都可以补充食物。但每次补充食物都需要花费时间，在它竹筐的食物足够可以走到下一个村庄的时候它就不用补充，这样背起来不累而且不花费时间。地图上可以看到村庄之间的距离，现在它要规划一下它的路线，确定在哪些村庄补充食物可以使沿途补充食物的次数最少。你能帮帮度度熊吗？
 * 输入
 * 第一行有两个数字，第一个数字为竹筐装满可以走的公里数，即N值；第二个数字为起点到终点之间的村庄个数。
 * 第二行为起点和村庄、村庄之间、村庄和终点之间的距离。
 * 这些数字都为整数，且范围不能超过一个int型表达的范围。
 * 输出
 * 程序输出为至少需要补充食物的次数
 * <p>
 * 样例输入
 * 7  4
 * 5  6  3  2  2
 * 样例输出
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int max = in.nextInt();
            int villageNumber = in.nextInt();
            int[] villageCost = new int[villageNumber + 1];
            for (int i = 0; i < villageNumber + 1; i++) {
                villageCost[i] = in.nextInt();
            }
            int rechargeCount = 0;
            int currentVillage = 0;
            int currentFood = max;
            while (currentVillage < villageNumber) {
                if (currentFood >= villageCost[currentVillage]) {
                    currentFood -= villageCost[currentVillage++];
                } else {
                    if (max < villageCost[currentVillage]) {
                        break;
                    }
                    rechargeCount++;
                    currentFood = max - villageCost[currentVillage++];
                }
            }
            System.out.println(rechargeCount);
        }
    }
}
