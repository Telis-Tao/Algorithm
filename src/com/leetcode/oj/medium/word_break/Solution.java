package com.leetcode.oj.medium.word_break;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
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
		String str = "aaaaaaa";
		Set<String> set = new HashSet<String>();
		set.add("aaaa");
		set.add("aaa");
		boolean b = s.wordBreak(str, set);
		System.out.println(b);
	}

	public boolean wordBreak(String s, Set<String> dict) {
		int start = 0;
		return wordBreak(s, dict, 0);
	}

	public boolean wordBreak(String s, Set<String> dict, int start) {
		if (s == null || s.length() == 0)
			return false;
		else if (dict.contains(s))
			return true;
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int end = 1; end < s.length() + 1; end++) {
			for (int i = 0; i < list.size(); i++) {
				if(dict.contains(s.substring(list.get(i), end))){
					list.add(end);
					break;
				}
			}
		}
		return list.contains(s.length());
	}
}
