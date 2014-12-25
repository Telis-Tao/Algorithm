package com.leetcode.oj.hard.median_of_two_sorted_arrays;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
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
		int[] A = new int[] {};
		int[] B = new int[] { 1 };
		System.out.println(new Solution().findMedianSortedArrays(A, B));
	}

	/**
	 * 这个是我新写的一个版本，算法复杂度很低，只有O（1）的空间复杂度，而且算法复杂度也只有O((m+n)/2)
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		int[] result;
		int isNull = 0;
		;
		if (A == null && B == null) {
			return 0;
		} else if (A == null) {
			isNull = 1;
			result = B;
		} else if (B == null) {
			isNull = 2;
			result = A;
		} else {
			result = new int[A.length + B.length];
		}
		if (isNull != 0) {
			if (result.length % 2 == 0) {
				return (result[result.length / 2 - 1] + result[result.length / 2]) / 2.0;
			} else {
				return result[result.length / 2];
			}
		} else {
			int count = 0;
			int ap = 0;
			int bp = 0;
			int min = 0;
			int second = 0;
			while (count <= (A.length + B.length) / 2 && ap < A.length
					&& bp < B.length) {
				if (A[ap] > B[bp]) {
					second = min;
					min = B[bp++];
					count++;
				} else {
					second = min;
					min = A[ap++];
					count++;
				}
			}
			while (count <= (A.length + B.length) / 2 && ap < A.length) {
				second = min;
				min = A[ap++];
				count++;
			}
			while (count <= (A.length + B.length) / 2 && bp < B.length) {
				second = min;
				min = B[bp++];
				count++;
			}
			// System.out.println("min:"+min+" second:"+second);
			if ((A.length + B.length) % 2 == 0) {
				return (min + second) / 2.0;
			} else {
				return min;
			}
		}
	}
	// 这里我运行的空间复杂度有O(m+n)
	// public double findMedianSortedArrays(int A[], int B[]) {
	// int[] result;
	// boolean isNull = false;;
	// if (A == null && B == null) {
	// return 0;
	// } else if (A == null) {
	// isNull = true;
	// result = B;
	// } else if (B == null) {
	// isNull = true;
	// result = A;
	// } else {
	// result = new int[A.length + B.length];
	// }
	// if(!isNull){
	// int ap = 0;
	// int bp = 0;
	// int pos = 0;
	// while (ap < A.length && bp < B.length) {
	// if (A[ap] > B[bp]) {
	// result[pos++] = B[bp++];
	// } else {
	// result[pos++] = A[ap++];
	// }
	// }
	// while (ap < A.length) {
	// result[pos++] = A[ap++];
	// }
	// while (bp < B.length) {
	// result[pos++] = B[bp++];
	// }
	// }
	// // System.out.println(Arrays.toString(result));
	// if (result.length % 2 == 0) {
	// return (result[result.length / 2-1] + result[result.length / 2 ]) / 2.0;
	// } else {
	// return result[result.length / 2];
	// }
	// }
}
