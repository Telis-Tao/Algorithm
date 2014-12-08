package com.leetcode.oj.easy.plus_one;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author Telis
 * 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(Arrays.toString(s
				.plusOne(new int[] { 1, 2, 3, 4, 5 })));
		System.out
				.println(Arrays.toString(s.plusOne(new int[] { 9, 9, 9, 9 })));
	}

	public int[] plusOne(int[] digits) {
		if (digits.length < 1)
			return digits;
		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		int temp = 0;
		for (int i = digits.length - 1; i > 0; i--) {
			if (digits[i] > 9) {
				digits[i] -= 10;
				temp++;
			}
			if (temp != 0) {
				digits[i - 1]++;
				temp = 0;
			}
		}
		if (temp != 0) {
			digits[0]++;
		}
		if (digits[0] <= 9) {
			return digits;
		} else {
			digits[0] -= 10;
			int[] result = new int[digits.length+1];
			result[0] = 1;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;
		}
	}
}
