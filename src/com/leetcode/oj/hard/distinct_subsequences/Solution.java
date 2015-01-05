package com.leetcode.oj.hard.distinct_subsequences;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// System.out.println(s.numDistinct("aabb", "abb"));
		System.out.println(s.numDistinct("eee", "eee"));
		// System.out.println(s.numDistinct("rabbbit", "rabbit"));
	}

	/**
	 * 这个感觉也比较难啊。。。差一点就推出来公式了，太可惜了，不过最后优化了一下，空间复杂度只有O(n),计算复杂度有O(n*m)(其实可以进一步优化的
	 * ，因为这里有一些地方必然为0(已经优化))
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct(String S, String T) {
		if (T.length() < 1 || S.length() < 1)
			return 0;
		if (S.length() < T.length())
			return 0;
		int[] former = new int[S.length() + 1];
		int[] results = new int[S.length() + 1];
		for (int i = 0; i < former.length; i++) {
			former[i] = 1;
		}
		for (int i = 1; i <= T.length(); i++) {
			for (int j = i; j < results.length; j++) {
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					results[j] = results[j - 1] + former[j - 1];
				} else {
					results[j] = results[j - 1];
				}
			}
			for (int j = 0; j < results.length; j++) {
				former[j] = results[j];
				results[j] = 0;
			}
		}
		return former[former.length - 1];
	}

}
