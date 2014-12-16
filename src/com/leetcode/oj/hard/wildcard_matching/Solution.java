package com.leetcode.oj.hard.wildcard_matching;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

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
		System.out.println(s.isMatch("aa", "*a"));
	}

	public boolean isMatch(String s, String p) {
		// System.out.print(s + "," + p + ":");
		int formerSig = 0;
		int lastSig = 0;// 0:other, 1:* ,2:?
		int index = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '?') {
				formerSig = lastSig;
				lastSig = 2;
				index++;
			} else if (p.charAt(i) == '*') {
				formerSig = lastSig;
				lastSig = 1;
			} else {
				if (index >= s.length()) {
					return false;
				}
				if (lastSig == 1) {
					formerSig = lastSig;
					lastSig = 0;
					while (index < s.length()) {
						if (s.charAt(index++) == p.charAt(i)) {
							break;
						}
					}
					if (index > s.length()) {
						return false;
					}
				} else {
					if (s.charAt(index) == p.charAt(i)) {
						index++;
					} else {
						return false;
					}
				}
			}
		}
		if (lastSig == 1) {
			if (index <= s.length()) {
				return true;
			} else {
				return false;
			}
			// return true;
		}
		if (lastSig == 2) {
			if (formerSig == 1) {
				if (index <= s.length())
					return true;
			}
			if (index == s.length()) {
				return true;
			} else {
				return false;
			}
		}
		if (lastSig == 0) {
			
		}
		return false;
	}
}
