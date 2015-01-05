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
		Solution s = new Solution();
		System.out.println(s.findMin(new int[] { 4, 5, 6, 7, -3, 1, 2 }));
		System.out.println(s.findMin(new int[] { 2, 1 }));
		System.out.println(s.findMin(new int[] { 2, 3, 1 }));
	}

	public int findMin(int[] num) {
		if (num == null)
			return 0;
		if (num.length < 2)
			return num[0];
		int start = 0;
		int end = num.length - 1;
		while (start <= end) {
			if (num[start] < num[end])
				return num[start];
			int half = (start + end) / 2;
			if (half > 0 && num[half] < num[half - 1]) {
				return num[half];
			}
			if (num[half] >= num[start]) {
				start = half + 1;
			} else if (num[half] <= num[start]) {
				end = half - 1;
			}
		}
		return -1;
	}

}