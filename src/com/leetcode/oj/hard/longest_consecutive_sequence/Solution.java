package com.leetcode.oj.hard.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
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
		// System.out.println(s.longestConsecutive(new int[] { 100, 4, 200, 1,
		// 3,
		// 2 }));
		// System.out.println(s.longestConsecutive(new int[] { 1, 2, 0 ,1}));
		// System.out.println(s.longestConsecutive(new int[] { 0 }));
		System.out.println(s.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8,
				4, 6, 0, 1 }));
	}

	public int longestConsecutive(int[] num) {
		if (num.length == 1) {
			return 1;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
		int max = 1;
		for (int n : num) {
			int count = 1;
			int i = 0;
			while (set.contains(n - ++i)) {
				count++;
				set.remove(n - i);
			}
			i = 0;
			while (set.contains(n + (++i))) {
				count++;
				set.remove(n + i);
			}
			max = Math.max(max, count);
		}
		return max;
	}
}
