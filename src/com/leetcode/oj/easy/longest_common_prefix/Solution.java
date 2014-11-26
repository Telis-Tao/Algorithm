package com.leetcode.oj.easy.longest_common_prefix;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
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
		// String[] strs = { "asdfasdf", "asdghfgh", "asd", "asdtert",
		// "asdpouih" };
		String[] strs = { "aa", "ab" };
		String prefix = s.longestCommonPrefix(strs);
		System.out.println(prefix);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String compareStr = strs[0];
		int minLen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			if (compareStr.length() > strs[i].length()) {
				compareStr = strs[i];
			}
		}
		minLen = compareStr.length();
		boolean isPrefix = true;
		for (int i = minLen; i > 0; i--) {
			for (int j = 0; j < strs.length; j++) {
				if (!(compareStr.substring(0, i)
						.equals(strs[j].substring(0, i)))) {
					isPrefix = false;
					break;
				}

			}
			if (isPrefix) {
				return compareStr.substring(0, i);
			} else
				isPrefix = true;
		}
		return "";
	}
}
