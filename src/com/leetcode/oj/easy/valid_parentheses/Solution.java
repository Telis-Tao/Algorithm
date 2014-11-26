package com.leetcode.oj.easy.valid_parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
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
		boolean b = s.isValid("((");
		System.out.println(b);
	}

	public boolean isValid(String s) {
		if (s == null)
			return false;
		s = s.replaceAll("[^()\\[\\]{}]", "");
		char[] c = s.toCharArray();
		if (c.length % 2 != 0)
			return false;
		char symbol = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < c.length; i++) {
			char tempC = c[i];
			if (tempC == '[' || tempC == '(' || tempC == '{') {
				stack.push(tempC);
			} else {
				if (stack.empty())
					return false;
				switch (stack.pop()) {
				case '(':
					symbol = ')';
					break;
				case '[':
					symbol = ']';
					break;
				case '{':
					symbol = '}';
					break;
				}
				if (tempC != symbol) {
					return false;
				}
			}
		}
		if(stack.empty())
			return true;
		return false;
	}
}
