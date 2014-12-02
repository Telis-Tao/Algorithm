package com.leetcode.oj.medium.sqrt;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println("result:" + s.sqrt(2147483647));
		System.out.println("result:" + s.sqrt(91));
		System.out.println("result:" + s.sqrt(2));
		System.out.println("result:" + s.sqrt(10));
	}

	public int sqrt(int x) {
		if (x < 0)
			return x;
		if (x == 0 | x == 1)
			return x;
		// max :2147483647
		// maxSqrt :46340
		int result = sqrt(x, 1, 46340);
		return result;
	}

	public int sqrt(int x, int start, int end) {
		int half = (start + end) / 2;
		// System.out
		// .println("start:" + start + "\thalf:" + half + "\tend:" + end);
		if ((half - 1) * (half - 1) < x && half * half > x) {
			return half - 1;
		}
		if (start < end) {
			if (half * half > x) {
				return sqrt(x, start, half - 1);
			} else if (half * half < x) {
				return sqrt(x, half + 1, end);
			}

		} else {
			return half;
		}
		return half;
	}
}
