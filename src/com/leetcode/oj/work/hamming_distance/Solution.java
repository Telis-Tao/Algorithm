package com.leetcode.oj.work.hamming_distance;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, calculate the Hamming distance.
 * <p>
 * Note:
 * 0 ≤ x, y < 231.
 * <p>
 * Example:
 * <p>
 * Input: x = 1, y = 4
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.hammingDistance(1, 4));
        System.out.println(s.hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        int orResult = x ^ y;
        int result = 0;
        while (orResult != 0) {
            result += orResult & 1;
            orResult >>= 1;
        }
        return result;
    }
}
