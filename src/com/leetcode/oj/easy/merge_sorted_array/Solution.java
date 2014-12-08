package com.leetcode.oj.easy.merge_sorted_array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 * 这道题出的不是很好，最后虽然AC了，但是默认为两个都是升序，没有考虑别的情况，而且也就最基本 的合并排序，没有什么技术含量
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
		int[] A = new int[] { 1, 2, 3 };
		int[] B = new int[] { 2, 5, 6 };
		int[] num = new int[A.length + B.length];
		for (int i = 0; i < A.length; i++) {
			num[i] = A[i];
		}
		s.merge(num, A.length, B, B.length);
		System.out.println(Arrays.toString(num));
	}

	public void merge(int A[], int m, int B[], int n) {
		if (n == 0) {
			return;
		}
		if (m == 0) {
			for (int i = 0; i < B.length; i++) {
				A[i] = B[i];
			}
			return;
		}
		if (A[m - 1] <= B[0]) {
			for (int i = 0; i < B.length; i++) {
				A[i + m] = B[i];
			}
			return;
		}
		for (int i = m - 1; i >= 0; i--) {
			A[i + n] = A[i];
		}
		int a = n;
		int b = 0;
		int current = 0;
		while (a < m + n && b < n) {
			if (A[a] > B[b]) {
				A[current++] = B[b++];
			} else {
				A[current++] = A[a++];
			}
		}

		// System.out.println(Arrays.toString(A));
		// System.out.println(a);
		// System.out.println(b);
		// System.out.println(current);
		while (a < m + n) {
			A[current++] = A[a++];
		}
		while (b < n) {
			A[current++] = B[b++];
		}
		// System.out.println(Arrays.toString(A));
	}
}
