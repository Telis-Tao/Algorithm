package com.leetcode.oj.medium.pow;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.pow(-1.00000, 2147483647));
	}

	public double pow(double x, int n) {
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double result = 1;
		for (double i = x; n > 0; n = n >> 1) {
			if (n % 2 == 1) {
				result *= i;
			}
			i = i * i;
		}
		return result;
	}
}
