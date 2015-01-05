package com.leetcode.oj.hard.wildcard_matching;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") ¡ú false isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false isMatch("aa", "*") ¡ú true isMatch("aa", "a*") ¡ú
 * true isMatch("ab", "?*") ¡ú true isMatch("aab", "c*a*b") ¡ú false
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
		System.out.println(s.isMatch("aa", "a"));
	}

	public boolean isMatch(String s, String p) {
		int left = 0;
		int right = 0;
		int start = -1;
		int match = 0;
		while (left < s.length()) {
			if (right < p.length()
					&& (p.charAt(right) == s.charAt(left) || p.charAt(right) == '?')) {
				left++;
				right++;
			} else if (right < p.length()&&p.charAt(right) == '*') {
				start = right;
				match = left;
				right++;
			} else if (start != -1) {
				right = start + 1;
				match++;
				left = match;
			} else {
				return false;
			}
		}
		while (right < p.length() && p.charAt(right) == '*') {
			right++;
		}
		return right == p.length();
	}
	// public boolean isMatch(String s, String p) {
	// // System.out.print(s + "," + p + ":");
	// int sIndex = 0, pIndex = 0, match = 0, starIdx = -1;
	// while (sIndex < s.length()){
	// // advancing both pointers
	// if (pIndex < p.length() && (p.charAt(pIndex) == '?' || s.charAt(sIndex)
	// == p.charAt(pIndex))){
	// sIndex++;
	// pIndex++;
	// }
	// // * found, only advancing pattern pointer
	// else if (pIndex < p.length() && p.charAt(pIndex) == '*'){
	// starIdx = pIndex;
	// match = sIndex;
	// pIndex++;
	// }
	// // last pattern pointer was *, advancing string pointer
	// else if (starIdx != -1){
	// pIndex = starIdx + 1;
	// match++;
	// sIndex = match;
	// }
	// //current pattern pointer is not star, last patter pointer was not *
	// //characters do not match
	// else return false;
	// }
	//
	// //check for remaining characters in pattern
	// while (pIndex < p.length() && p.charAt(pIndex) == '*')
	// pIndex++;
	//
	// return pIndex == p.length();
	// }
}
