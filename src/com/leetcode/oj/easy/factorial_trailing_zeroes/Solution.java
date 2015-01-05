package com.leetcode.oj.easy.factorial_trailing_zeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
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
//		System.out.println(21/5*5);
		for (int i = 1; i < 31; i++) {
			System.out.println(i+":"+new Solution().trailingZeroes(i));
		}
	}

	public int trailingZeroes(int n) {
//		System.out.println(count(n));
//		System.out.println(n/5);
		return n==0?0:n/5+trailingZeroes(n/5);
	}
	
	public int count(int n){
		if(n<1)
			return 1;
		return n/5*5*count(n-5);
	}
}
