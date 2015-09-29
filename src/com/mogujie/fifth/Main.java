package com.mogujie.fifth;

import java.util.Scanner;

/**
 * [编程题] 回文串
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 * <p>
 * 输入描述:
 * 一行一个由小写字母构成的字符串，字符床长度小于等于10。
 * <p>
 * <p>
 * 输出描述:
 * 输出答案(YES\NO).
 * <p>
 * 输入例子:
 * coco
 * <p>
 * 输出例子:
 * YES
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            boolean isHuiWen = false;
            for (int i = 0; i < str.length() + 1; i++) {
                for (int j = 0; j < 26; j++) {
                    String testString = str.substring(0, i) + (char) ('a' + j) + str.substring(i);
                    if (isHuiWen(testString)) {
                        System.out.println("YES");
                        isHuiWen = true;
                        break;
                    }
                }
                if (isHuiWen) {
                    break;
                }
            }
            if (!isHuiWen) {
                System.out.println("NO");
            }
        }
    }

    private static boolean isHuiWen(String testString) {
        int left = 0;
        int right = testString.length() - 1;
        while (left < right) {
            if (testString.charAt(left) != testString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
