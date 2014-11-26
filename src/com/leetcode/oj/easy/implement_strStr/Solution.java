package com.leetcode.oj.easy.implement_strStr;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
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

	}

	public String strStr(String haystack, String needle) {
		int index = haystack.indexOf(needle);
		if (index == -1)
			return null;
		return haystack.substring(index);
	}
}
