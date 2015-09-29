package com.didi.first;

import java.util.*;

/**
 * Created by taoxiaoqing on 15/9/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while (in.hasNext()) {
            list.add(in.nextInt());
        }
        int length = list.size();
        int[][] res = new int[length][length];
        for (int i = 0; i < length; i++) {
            res[i][i] = list.get(i);
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                res[i][j] = res[i][j - 1] + list.get(j);
            }
        }
        int start = -1;
        int end = -1;
        int maxLength = -1;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (res[i][j] == 0) {
                    int tmpLength = j - i + 1;
                    if (tmpLength > maxLength) {
                        start = i;
                        end = j;
                        maxLength = tmpLength;
                    }
                }
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
