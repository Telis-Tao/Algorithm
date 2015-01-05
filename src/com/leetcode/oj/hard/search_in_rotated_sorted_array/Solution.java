package com.leetcode.oj.hard.search_in_rotated_sorted_array;

import java.util.Arrays;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.search(new int[] { 5, 1, 3 }, 5));
	}

	public int search(int[] A, int target) {
		if (A.length < 1)
			return -1;
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			if (A[start] < A[end]) {
				return binarySearch(A, start, end, target);
			}
			int half = (start + end) / 2;
			if (A[half] >= A[start]) {
				if (target >= A[start] && target <= A[half]) {
					return binarySearch(A, start, half , target);
				} else {
					start = half + 1;
				}
			} else {
				if (target >= A[half] && target <= A[end]) {
					return binarySearch(A, half, end, target);
				} else {
					end = half - 1;
				}
			}

		}
		return target == A[end] ? end : -1;
	}

	private int binarySearch(int[] A, int start, int end, int target) {
		while (start <= end) {
			int half = (start + end) / 2;
			if (A[half] == target) {
				return half;
			} else if (A[half] < target) {
				start = half + 1;
			} else {
				end = half - 1;
			}
		}
		return -1;
	}
	// public int search(int[] A, int target) {
	// if (A.length < 2)
	// if (A[0] != target)
	// return -1;
	// else
	// return 0;
	// int peak = -1;
	// if (A[0] < A[A.length - 1]) {
	// peak = A.length - 1;
	// } else if (A[0] > A[1]) {
	// peak = 0;
	// } else {
	// peak = findPeak(A, 1, A.length);
	// }
	// System.out.println("peak:" + peak);
	// if (peak == A.length - 1) {
	// if (target > A[A.length - 1] || target < A[0]) {
	// return -1;
	// }
	// return find(A, 0, A.length - 1, target);
	// } else {
	// if (target == A[peak]) {
	// return peak;
	// } else if (target > A[peak] || target < A[peak + 1]) {
	// return -1;
	// } else {
	// if (target > A[0]) {
	// return find(A, 0, peak, target);
	// } else if (target < A[0]) {
	// return find(A, peak + 1, A.length-1, target);
	// } else {
	// return 0;
	// }
	// }
	// }
	// // return 0;
	// }

	// private int find(int[] A, int start, int end, int target) {
	// // TODO Auto-generated method stub
	// if (start <= end) {
	// int half = (start + end) / 2;
	// if (target < A[half]) {
	// return find(A, start, half - 1, target);
	// } else if (target > A[half]) {
	// return find(A, half + 1, end, target);
	// } else {
	// return half;
	// }
	// }
	// return -1;
	// }
	//
	// public int findPeak(int[] A, int start, int end) {
	// if (start < end) {
	// int half = (start + end) / 2;
	// if (half < A.length - 1 && A[half] > A[half + 1])
	// return half;
	// if (A[half] > A[0]) {
	// return findPeak(A, half, end);
	// }
	// if (A[half] < A[0]) {
	// return findPeak(A, 0, half);
	// }
	// }
	// return -1;
	// }
}
