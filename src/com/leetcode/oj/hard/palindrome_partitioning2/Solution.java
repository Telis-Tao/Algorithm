package com.leetcode.oj.hard.palindrome_partitioning2;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
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
		 s.minCut("ccbcc");
		// s.minCut("aaabaa");
		// s.minCut("aaaaabaacc");
		s.minCut("dde");
	}

	/**这个是看的DISCUSS中做的，我也想到了用DP，但是TLE了。。。
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		if (s.equals(""))
			return 0;
		int[] result = new int[s.length() + 1];
		result[0]=-1;
		for (int i = 1; i < result.length; i++) {
			result[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < s.length(); i++) {
			for (int left = i, right = i; left >= 0
					&& right < s.length() && s.charAt(left) == s.charAt(right); left--, right++) {// odd
				result[right+1] = Math.min(result[right+1], result[left] + 1);
			}
			for (int left = i-1, right = i; left >= 0 && right < s.length()
					&& s.charAt(left) == s.charAt(right); left--, right++) {// odd
				result[right+1] = Math.min(result[right+1], result[left] + 1);
			}
		}
//		System.out.println(Arrays.toString(result));
		return result[result.length - 1];
	}

}
