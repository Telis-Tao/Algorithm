package com.liebao.first;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 分词方法数
 * 程序运行时间限制：1秒
 * <p/>
 * 问题描述：
 * <p/>
 * 给定一个包含N个单词的词典，以及一个长度为M的文本，现需对该文本进行分词，一种合法的分词方案要求分词结果中的所有单词都在给定词典中，问有多少种不同的分词方法。
 * <p/>
 * 比如给定词典包含5个单词： [a, b, ab, bb, abb]，给定文本为 “aabbaa”, 那么有以下 4 种不同的分词方法（示例用竖线表示分单）：
 * a|abb|a|a
 * a|a|bb|a|a
 * a|ab|b|a|a
 * a|a|b|b|a|a
 * <p/>
 * 输入描述：
 * 输入第一行为词典单词个数N，后面N行，每行一个单词，N <= 1000，单词仅含小写字母，单词长度<16
 * 最后一行为需要分词的文本，长度为M，M <= 1000。
 * <p/>
 * 输出描述：
 * 输出一行，为一个整数表示给定文本的分词方法数模10000（即取结果后4位），若不存在合法的分词方法则输出0
 * <p/>
 * 输入样例：
 * 5
 * a
 * b
 * ab
 * bb
 * abb
 * aabbaa
 * <p/>
 * 输出样例：
 * 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < count; i++) {
                set.add(in.next());
            }
            String text = in.next();
            long[] result = new long[text.length()];
            for (int i = 0; i < result.length; i++) {
                for (String s : set) {
                    int end = i + 1;
                    int start = end - s.length();
                    if (start < 0) {
                        continue;
                    }
                    String subString = text.substring(start, end);
                    if (s.equals(subString)) {
                        if (start == 0) {
                            result[i]++;
                        } else {
                            result[i] += result[start - 1];
                        }
                    }
                }
            }
            long res = result[result.length - 1];
            res = res % 10000;
            System.out.println(res);
        }
    }
}
