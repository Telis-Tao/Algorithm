package com.leetcode.oj.hard.find_mimimum_in_rotated_sorted_array2;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
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
		System.out.println(s.findMin(new int[] { 4, 5, 6, 7, 7, 7, -3, 1, 2 }));
		System.out.println(s.findMin(new int[] { 4, 4, 4, 5, 6, 7, -3, 1, 2 }));
		System.out.println(s.findMin(new int[] { 1, 1, 2 }));
		System.out.println(s.findMin(new int[] { 2, 3, 1 }));
		System.out.println(s.findMin(new int[] { 10, 1, 10, 10, 10 }));
		System.out.println(s.findMin(new int[] { 1, 2, 1 }));
		System.out.println(s.findMin(new int[] { 1, 2, 1, 1, 1, 1, 1 }));
	}

	/**
	 * 这个感觉没有什么太大的变化，只需要多分析重复的情况: 1.重复部分是最小值 2.重复部分被分割 3.重复部分是其他值
	 * 
	 * @param num
	 * @return
	 */
	public int findMin(int[] num) {
		if (num == null)
			return 0;
		if (num.length < 2)
			return num[0];
		int start = 0;
		int end = num.length - 1;
		while (start < end) {
			if (start < end && num[start] == num[end]) {
				// start++;
				end--;
			}
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
		return num[end];
	}
}
