package com.leetcode.oj.medium.divide_two_integers;

/**
 * Divide two integers without using multiplication, division and mod operator.
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
		// System.out.println(s.divide(-1, 1));
		// System.out.println(s.divide(1, -1));
		// System.out.println(s.divide(2,2));
		System.out.println(s.divide(-2147483648, 2));
	}

	public int divide(int dividend, int divisor) {
		boolean isNeg = divisor < 0;
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1 || divisor == -1)
			return isNeg ? -dividend : dividend;
		isNeg = divisor < 0 ^ dividend < 0;
		long dividendLong = Math.abs((long) dividend);
		long divisorLong = Math.abs((long) divisor);
		if (divisorLong > dividendLong)
			return 0;
		long result = 0;
		long count = 1;
		boolean flag = false;
		while (divisorLong != 0 && divisorLong < dividendLong) {
			flag = true;
			divisorLong = divisorLong << 1;
			count = count << 1;
		}
		if (flag) {
			divisorLong = divisorLong >> 1;
			count = count >> 1;
		}
		while (dividendLong >= 2 && divisorLong > 0) {
			if (dividendLong >= divisorLong) {
				result += count;
				dividendLong -= divisorLong;
			} else {
				divisorLong = divisorLong >> 1;
				count = count >> 1;
			}
		}
		if (isNeg) {
			result = -result;
		}
		return (int) result;
	}
}
