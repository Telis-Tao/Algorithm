package com.leetcode.oj.medium.maximum_subarray;

public class MoreSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoreSolution s = new MoreSolution();
		System.out.println(s.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1,
				-5, 4 }));
		System.out.println(s.maxSubArray(new int[] { -2, -1 }));
		System.out.println(s.maxSubArray(new int[] { 2, -1, 1, 1 }));
	}

	public int maxSubArray(int[] A) {
		return maxSubArray(A, 0, A.length - 1);
	}

	public int maxSubArray(int[] A, int start, int end) {
		if (start == end) {
			return A[start];
		}
		int half = (start + end) / 2;
		int leftM = maxSubArray(A, start, half);
		int rightM = maxSubArray(A, half + 1, end);
		int left = A[half];
		int temp = 0;
		for (int i = half; i >= start; i--) {
			temp += A[i];
			if (temp > left)
				left = temp;
		}
		temp = 0;
		int right = A[half + 1];
		for (int i = half + 1; i <= end; i++) {
			temp += A[i];
			if (temp > right)
				right = temp;
		}
		int max = Math.max(Math.max(left, right), left + right);
		return Math.max(Math.max(leftM, rightM), max);
	}
}
