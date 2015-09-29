package com.didi.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by taoxiaoqing on 15/9/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //                List<List<Integer>> list = new ArrayList<List<Integer>>();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            //        String str = "1 2 0 3 4 ; 2 3 4 5 1 ; 1 1 5 3 0";
            String[] rows = str.split(";");
            int rowLength = rows.length;
            //        String[] element = rows[0].trim().split(" ");
            //        System.out.println(Arrays.toString(element));
            int columnLength = rows[0].trim().split(" ").length;
//            System.out.println(rowLength);
//            System.out.println(columnLength);
            int[][] matrix = new int[rowLength][columnLength];
            for (int i = 0; i < rowLength; i++) {
                String[] elements = rows[i].trim().split(" ");
                for (int j = 0; j < columnLength; j++) {
                    matrix[i][j] = Integer.valueOf(elements[j]);
                }
            }
//            for (int[] ints : matrix) {
            //                System.out.println(Arrays.toString(ints));
            //            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < rowLength; i++) {
                for (int j = 1; j < columnLength; j++) {
                    int sum = matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] + matrix[i - 1][j - 1];
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
            System.out.println(max);
        }
    }

}
