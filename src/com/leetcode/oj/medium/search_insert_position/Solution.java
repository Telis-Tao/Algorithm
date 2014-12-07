package com.leetcode.oj.medium.search_insert_position;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
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
		// int[] A = { 1, 2, 3 };
		int[] A = { 3, 5, 7, 9, 10 };
		Solution s = new Solution();
		System.out.println(s.searchInsert(A, 8));
		// System.out.println(s.searchInsert(A, 5));
		// System.out.println(s.searchInsert(A, 2));
		// System.out.println(s.searchInsert(A, 7));
		// System.out.println(s.searchInsert(A, 0));
	}

	public int searchInsert(int[] A, int target) {
		return searchInsert(A, target, 0, A.length - 1);
	}

	public int searchInsert(int[] A, int target, int start, int end) {
		if (start < end) {
			int half = (start + end) / 2;
			// System.out.println("half:" + half);
			if (A[half] > target) {
				return searchInsert(A, target, start, half - 1);
			} else if (A[half] < target) {
				return searchInsert(A, target, half + 1, end);
			} else {
				return half;
			}
		} else if (start == end) {
			while (start < A.length && A[start] < target) {
				start++;
			}
			return start;
		}
		return start;
	}
}
