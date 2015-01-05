package com.leetcode.oj.medium.unique_binary_search_trees;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		for (int i = 1; i < 10; i++) {
			System.out.println(s.numTrees(i));
		}
	}

	public int numTrees(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int[] results = new int[n + 1];
		results[0] = 1;
		results[1] = 1;
		int i = 2;
		while (i <= n) {
			int left = 0;
			int result = 0;
			while (left < i) {
				int right = i - left - 1;
				result += results[left] * results[right];
				// System.out.println(left+":"+right);
				left++;
			}
			results[i] = result;
			// System.out.println(Arrays.toString(results));
			i++;
		}
		return results[results.length - 1];
	}
}
