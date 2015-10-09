package com.netease.second;

import java.util.Scanner;

/**
 * 扫描透镜
 * Time Limit: 1000/1000 MS (Java/Others) Memory Limit: 32768/32768 K (Java/Others)
 * Problem Description:
 * 在N*M的草地上，提莫种了K个蘑菇，蘑菇爆炸的威力极大，兰博不想贸然去闯，而且蘑菇是隐形的，只有一种叫做扫描透镜的物品可以扫描出隐形的蘑菇，于是他回了一趟战争学院，买了两个扫描透镜。一个扫描透镜可以扫描出（3*3
 * ）的方格中所有蘑菇，然后兰博就可以清理掉一些隐形的蘑菇。
 * <p>
 * 问：兰博最多可以清理多少个蘑菇？
 * 输入
 * 第一行三个整数:N,M,K (1 <= N,M <= 20 , k <= 100)，N，M代表了草地的大小；
 * 接下来K行，每行两个整数x,y。代表(x,y)处提莫种了一个蘑菇。
 * 一个方格可以种无穷个蘑菇。
 * 输出
 * 输出一行，在这一行输出一个整数，代表兰博最多可以清理多少个蘑菇。
 * <p>
 * 样例输入
 * 3 3 3
 * 1 1
 * 1 2
 * 1 3
 * 样例输出
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int count = in.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < count; i++) {
                int j = in.nextInt();
                int k = in.nextInt();
                matrix[j - 1][k - 1]++;
            }
            int answer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int firstResult = getCount(matrix, i, j);
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            int secondResult = firstResult;
                            secondResult += getCount(matrix, k, l);
                            secondResult -= removeDup(matrix, i, j, k, l);
                            if (secondResult > answer) {
                                answer = secondResult;
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static int removeDup(int[][] matrix, int i, int j, int k, int l) {
        //        if (Math.abs(i - k) > 2 || Math.abs(j - l) > 2) {
        //            return 0;
        //        }
        int result = 0;
        int[][] tmp = new int[matrix.length][matrix[0].length];
        for (int row = i - 1; row < i + 2; row++) {
            if (row >= 0 && row < matrix.length) {
                for (int column = j - 1; column < j + 2; column++) {
                    if (column >= 0 && column < matrix[row].length) {
                        tmp[row][column]++;
                    }
                }
            }
        }
        for (int row = k - 1; row < k + 2; row++) {
            if (row >= 0 && row < matrix.length) {
                for (int column = l - 1; column < l + 2; column++) {
                    if (column >= 0 && column < matrix[row].length) {
                        tmp[row][column]++;
                    }
                }
            }
        }
        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                if (tmp[m][n] == 2) {
                    result += matrix[m][n];
                }
            }
        }
        return result;
    }

    private static int getCount(int[][] matrix, int i, int j) {
        int result = 0;
        for (int row = i - 1; row < i + 2; row++) {
            if (row >= 0 && row < matrix.length) {
                for (int column = j - 1; column < j + 2; column++) {
                    if (column >= 0 && column < matrix[row].length) {
                        result += matrix[row][column];
                    }
                }
            }
        }
        return result;
    }
}
