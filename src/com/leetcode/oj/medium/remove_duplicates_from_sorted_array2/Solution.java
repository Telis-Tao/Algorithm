package com.leetcode.oj.medium.remove_duplicates_from_sorted_array2;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2]. Follow up for
 * "Remove Duplicates": What if duplicates are allowed at most twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
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
		 s.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3, 3, 3, 3 });
		s.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 });
	}

	public int removeDuplicates(int[] A) {
		if (A == null)
			return 0;
		if (A.length < 3)
			return A.length;
		int mark = A[0] - 1;
		int first = 0;
		int third = 2;
		int lenth = A.length;
		while (third < A.length) {
			boolean flag = false;
			while (third < A.length && A[first] == A[third]) {
				if (!flag)
					flag = true;
				third++;
				lenth--;
			}
			if (flag) {
				flag = false;
				int index = first + 2;
				while (index < third) {
					A[index++] = mark;
				}
				first = third;
				third = first + 2;
			} else {
				first++;
				third++;
			}
			System.out.println(first + " " + third + " " + Arrays.toString(A));
		}
		int index = 0;
		for (int i = 0; index < lenth; i++) {
			if (A[i] != mark) {
				A[index++] = A[i];
			}
		}
		System.out.println(lenth + " " + Arrays.toString(A));
		return lenth;
	}

	public void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
