package com.leetcode.oj.medium.single_number2;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
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
		int[] A = { 0, 0, 0, 5 };
		Solution s = new Solution();
//		int num = 7;
//		for (int i = 31; i >= 0; i--) {
//			System.out.print(num >> i & 1);
//		}
		System.out.println(s.singleNumber(A));
	}

	public int singleNumber(int[] A) {
		int num = 0;
		int[] result = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
//				System.out.print((A[j] >> i & 1) + "\t");
				if ((A[j] >> i & 1) == 1) {
					result[i]++;
				}
			}
//			System.out.println();
		}
//		System.out.println(Arrays.toString(result));
		for (int i = 0; i < result.length; i++) {
			result[i] = result[i] % 3;
			num = num | result[i] << i;
		}
		return num;
	}
}
