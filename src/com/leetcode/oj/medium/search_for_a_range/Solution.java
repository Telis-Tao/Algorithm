package com.leetcode.oj.medium.search_for_a_range;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] A = { 5, 7, 7, 8, 8, 10 };
		int[] A = { 1 };
		Solution s = new Solution();
		s.searchRange(A, 1);
	}

	public int[] searchRange(int[] A, int target) {
		int pos = searchRange(A, target, 0, A.length - 1);
		if (pos == -1) {
			return new int[] { -1, -1 };
		} else {
			int left = pos;
			int right = pos;
			while (left > 0 && A[left - 1] == target) {
				left--;
			}
			while (right < A.length - 1 && A[right + 1] == target) {
				right++;
			}
			return new int[] { left, right };
		}
	}

	public int searchRange(int[] A, int target, int start, int end) {
		if (start <= end) {
			if ((A[(start + end) / 2]) > target) {
				return searchRange(A, target, start, (start + end) / 2 - 1);
			} else if ((A[(start + end) / 2]) < target) {
				return searchRange(A, target, (start + end) / 2 + 1, end);
			} else {
				return (start + end) / 2;
			}
		} else {
			return -1;
		}
	}
}
