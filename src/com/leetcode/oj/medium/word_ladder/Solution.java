package com.leetcode.oj.medium.word_ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As
 * one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int min;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String start = "hit";
		String end = "cog";
		String[] strs = { "hot", "dot", "dog", "lot", "log" };
		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < strs.length; i++) {
			dict.add(strs[i]);
		}
		System.out.println(s.ladderLength(start, end, dict));
	}

	public int ladderLength(String start, String end, Set<String> dict) {
		dict.add(end);
		// TreeSet<Integer> set = new TreeSet<Integer>();
		min = dict.size();
		ladderLength(start, end, dict, 0);
		if (min == dict.size()) {
			return 0;
		} else {
			return min;
		}
	}

	public void ladderLength(String current, String end, Set<String> dict,
			int count) {
		if (count + 1 >= min) {
			return;
		}
		if (current.equals(end)) {
			min = Math.min(min, count + 1);
		} else {
			for (int i = 0; i < current.length(); i++) {
				for (int j = 0; j < 26; j++) {
					char c = (char) ('a' + j);
					if (c != current.charAt(i)) {
						String nStr = current.substring(0, i) + c
								+ current.substring(i + 1, current.length());
						if (dict.contains(nStr)) {
							dict.remove(nStr);
							ladderLength(nStr, end, dict, count + 1);
							dict.add(nStr);
						}
					}
				}
			}
		}
	}
}
