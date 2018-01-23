package com.leetcode.oj.medium.counting_bits;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        int index = 1;
        while (index < num) {
            index = index << 1;
        }
        for (int i = 0; i < num; i++) {

        }

        return results;
    }
}
