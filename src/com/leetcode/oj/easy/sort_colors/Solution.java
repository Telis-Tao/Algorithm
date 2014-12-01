package com.leetcode.oj.easy.sort_colors;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem. Follow up: A rather straight forward solution is a two-pass
 * algorithm using counting sort. First, iterate the array counting number of
 * 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's
 * and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
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
		 s.sortColors(new int[] { 1, 2, 0, 1 });
		 s.sortColors(new int[] { 1, 2, 0 });
		 s.sortColors(new int[] { 2, 1, 0 });
		 s.sortColors(new int[] { 2, 1, 1, 0 });
		 s.sortColors(new int[] { 2,2,0,0,2,0,2,1,0 });
		s.sortColors(new int[] { 2, 1, 2 });
	}

	public void sortColors(int[] A) {
		if (A == null || A.length <= 1)
			return;
		int left = 0;
		int right = A.length - 1;
		int current = A.length - 1;
		while (current >= 0) {
			if (A[current] == 2) {
				current--;
				right--;
			} else {
				break;
			}
		}
		current = 0;
		while (current < A.length) {
			if (A[current] == 0) {
				current++;
				left++;
			} else {
				break;
			}
		}
		while (left < right && current <= right) {
			if (A[current] == 0) {
				swap(A, left++, current);
			} else if (A[current] == 2) {
				swap(A, right--, current);
			} else {
				current++;
			}
			if (left >= current) {
				current = left + 1;
			}
//			System.out.println(left + " " + right + " " + current + "\t"
//					+ Arrays.toString(A));
		}
//		System.out.println(Arrays.toString(A));
	}

	public void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
