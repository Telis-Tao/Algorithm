package com.leetcode.oj.medium.search_in_rotated_sorted_array2;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
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
		System.out.println(s.search(new int[] {  1,1 }, 0));
	}

	public boolean search(int[] A, int target) {
		if (A.length < 1)
			return false;
		int start = 0;
		int end = A.length - 1;
		while (start < end) {
			if (A[start] < A[end]) {
				return binarySearch(A, start, end, target);
			}
			while(start<end&&A[start]==A[end]){
				end--;
			}
			int half = (start + end) / 2;
			if (A[half] >= A[start]) {
				if (target >= A[start] && target <= A[half]) {
					return binarySearch(A, start, half, target);
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
		return target == A[end] ? true : false;
	}

	private boolean binarySearch(int[] A, int start, int end, int target) {
		while (start <= end) {
			int half = (start + end) / 2;
			if (A[half] == target) {
				return true;
			} else if (A[half] < target) {
				start = half + 1;
			} else {
				end = half - 1;
			}
		}
		return false;
	}
}
