package com.leetcode.oj.medium.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
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
//		String str = "qwertyuiopasdfghjklzxcvbnm";
		 String str = "abbcd";
		int max = s.lengthOfLongestSubstring(str);
		System.out.println("max:" + max);
	}

	public int lengthOfLongestSubstring(String s) {
		char[] c = s.toCharArray();
		int[] used = new int[256];
		int max = 0;
		int tempMax = 0;
		for (int i = 0; i < c.length; i++) {
			if (used[c[i]] != 0) {
				max = max > tempMax ? max : tempMax;
				tempMax = 0;
				i = used[c[i]];
				used = new int[256];
			}
			tempMax++;
			used[c[i]] = i+1;
		}
		max = max > tempMax ? max : tempMax;
		return max;
	}
}
