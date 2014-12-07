package com.leetcode.oj.medium.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case
 * 
 * 
 * 
 * 这道题之前用暴力写的O(N^2)的TLE了，改用Hashtable来写 题目的意思是给一个String数组，找出其中由相同字母组成的单词。 例如： S =
 * ["abc", "bca", "bac", "bbb", "bbca", "abcb"] 答案为： ["abc", "bca", "bac",
 * "bbca", "abcb"]
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
		System.out.println(s.anagrams(new String[] { "abc", "bca", "bac",
				"bbb", "bbca", "abcb" }));
	}

	public List<String> anagrams(String[] strs) {
		String[] example = new String[strs.length];
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < example.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			example[i] = String.valueOf(c);
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < example.length; i++) {
			if (!map.containsKey(example[i])) {
				map.put(example[i], 1);
			} else {
				map.put(example[i], map.get(example[i]) + 1);
			}
		}
		for (int i = 0; i < example.length; i++) {
			if (map.get(example[i]) > 1) {
				list.add(strs[i]);
			}
		}
		return list;
	}
}
