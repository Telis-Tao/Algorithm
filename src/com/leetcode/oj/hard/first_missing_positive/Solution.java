package com.leetcode.oj.hard.first_missing_positive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int result = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().firstMissingPositive(new int[] { 1, 2, 1, 3, 4, 1, 1, 2,
				3, 4 });
		new Solution().firstMissingPositive(new int[] { 1, 2, 3, 4, 5, 6 });
		new Solution().firstMissingPositive(new int[] { 1,1,1,1,1,1,1});
	}

	public int firstMissingPositive(int[] A) {
		if (A.length < 2)
			return 0;
		// List<Integer> list = new ArrayList<Integer>();
		int[] marks = new int[A.length];
		for (int i = 1; i < A.length - 1; i++) {
			if (A[i] >= A[i - 1] && A[i] > A[i + 1]) {
				marks[i] = 1;
			}
			if (A[i] <= A[i - 1] && A[i] < A[i + 1]) {
				marks[i] = -1;
			}
		}
		if (A[0] < A[1]) {
			marks[0] = -1;
		}
		if (A[A.length - 1] > A[A.length - 2]) {
			marks[A.length - 1] = 1;
		}
//		System.out.println(Arrays.toString(marks));
		firstMissingPositive(A, -1, 0, 0, marks);
//		System.out.println(result);
		return 0;

	}

	public void firstMissingPositive(int[] A, int end, int count, int sum,
			int[] marks) {
		if (count < 2) {
			result = Math.max(result, sum);
			for (int i = end + 1; i < A.length; i++) {
				if (marks[i] == -1) {
					for (int j = i + 1; j < marks.length; j++) {
						if (marks[j] == 1) {
							int temp = A[j] - A[i] + sum;
							// System.out.println("i:"+i+" j:"+j+" sum:"+temp);
							firstMissingPositive(A, j, count + 1, temp, marks);
						}
					}
				}

			}
		}
		if (count == 2) {
			result = Math.max(result, sum);
		}
	}
}
