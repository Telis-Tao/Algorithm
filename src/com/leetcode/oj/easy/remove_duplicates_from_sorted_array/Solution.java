package com.leetcode.oj.easy.remove_duplicates_from_sorted_array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
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
		// int[] A = { -999, -999, -998, -998, -997, -997, -996, -996, -995,
		// -995,
		// -994, -994, -993, -993, -992, -992, -991 };
		int[] A = { 1 };
		int lenth = s.removeDuplicates(A);
		for (int i = 0; i < lenth; i++) {
			System.out.print(A[i] + "\t");
		}
	}

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return 1;
		int first = 0;
		int second = 1;
		int finalLenth = A.length;
		int lenth = finalLenth;
		for (int i = 1; i < lenth; i++) {
			if (A[first] == A[second]) {
				second++;
				finalLenth--;
			} else {
				A[++first] = A[second++];
			}

		}
		return finalLenth;
	}
}
