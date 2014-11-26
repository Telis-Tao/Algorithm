package com.leetcode.oj.medium.longest_palindromic_substring;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
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
//		System.out.println(s.longestPalindrome("abcbasdklsdf"));
		System.out.println(s.isPalindrome("caba".toCharArray(), 1, 3));
		System.out.println(s.longestPalindrome("caba"));
	}

	public String longestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		int lenth = s.length();
		char[] c = s.toCharArray();
		while (lenth > 0) {
			for (int i = 0; i < s.length() - lenth; i++) {
				if (!isPalindrome(c, i, i + lenth)) {
					continue;
				}
				return s.substring(i, i + lenth + 1);
			}
			lenth--;
		}
		return "";
	}

	public boolean isPalindrome(char[] c, int start, int end) {
		int lenth = end - start+1;
		int halfLenth = lenth / 2;
		for (int i = start; i < start + halfLenth; i++) {
			if (c[i] != c[end+start-i]) {
				return false;
			}
		}
		return true;
	}
}
