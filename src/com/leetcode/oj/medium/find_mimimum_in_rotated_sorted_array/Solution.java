package com.leetcode.oj.medium.find_mimimum_in_rotated_sorted_array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
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
		// int[] num = {4 ,5, 6, 7, 0, 1, 2};
		int[] num = { 2, 3, 1 };
		Solution s = new Solution();
		System.out.println(s.findMin(num));
	}

	public int findMin(int[] num) {
		if (num == null)
			return 0;
		int min = num[0];
		for (int i = 1; i < num.length - 1; i++) {
			if (num[i] < num[i - 1] && num[i] < num[i + 1]) {
				min = Math.min(min, num[i]);
			}
		}
		return Math.min(min, num[num.length - 1]);
	}
}
