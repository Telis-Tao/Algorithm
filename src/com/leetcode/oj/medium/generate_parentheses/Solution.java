package com.leetcode.oj.medium.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Telis
 * 
 */
public class Solution {
	private char[] results;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.generateParenthesis(2));
	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		results = new char[2 * n];
		generateParenthesis(n, list, 0, 0, 0);
		return list;
	}

	public void generateParenthesis(int n, List<String> list, int left,
			int right, int count) {
		if (count == n * 2) {
			if (left == right && left == n) {
				String temp = "";
				for (int i = 0; i < results.length; i++) {
					temp += results[i];
				}
				list.add(temp);
			}
		} else {
			if (left == right) {
				results[count] = '(';
				generateParenthesis(n, list, left + 1, right, count + 1);
			} else if (left > right) {
				results[count] = '(';
				generateParenthesis(n, list, left + 1, right, count + 1);
				results[count] = ')';
				generateParenthesis(n, list, left, right + 1, count + 1);
			} else if (left < right) {
				return;
			}
		}
	}
}
