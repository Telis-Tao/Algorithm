package com.leetcode.oj.medium.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	String[] results;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.partition("asa"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<List<String>>();
		// // Single word:
		// List<String> singleList = new ArrayList<String>();
		// for (int i = 0; i < s.length(); i++) {
		// singleList.add(String.valueOf(s.charAt(i)));
		// }
		// list.add(singleList);
		results = new String[s.length()];
		partition(s, list, 0, 0);
		// System.out.println(list);
		return list;
	}

	public void partition(String s, List<List<String>> list, int end, int count) {
		if (end == s.length()) {
			List<String> multiList = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				multiList.add(results[i]);
			}
			list.add(multiList);
		} else {
			for (int i = end + 1; i <= s.length(); i++) {
				// System.out.println(s.substring(end, i));
				if (isPalindrome(s.substring(end, i))) {
					results[count] = s.substring(end, i);
					partition(s, list, i, count + 1);
				}
				// System.out.println("i:"+i+" end:"+end+" "+Arrays.toString(results));
			}
		}

	}

	public boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}
}
