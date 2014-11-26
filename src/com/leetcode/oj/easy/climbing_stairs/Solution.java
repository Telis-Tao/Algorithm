package com.leetcode.oj.easy.climbing_stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
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
		System.out.println(s.climbStairs(4));
	}

	public int climbStairs(int n) {
		int[] count = new int[n];
		if (n == 0)
			return 0;
		count[0] = 1;
		if (n == 1)
			return count[0];
		count[1] = 2;
		if (n == 2)
			return count[1];
		for (int i = 2; i < n; i++) {
			count[i] = count[i - 1] + count[i - 2];
		}
		return count[n - 1];
	}
}
