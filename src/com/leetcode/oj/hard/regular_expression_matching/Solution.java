package com.leetcode.oj.hard.regular_expression_matching;

//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "a*") → true
//isMatch("aa", ".*") → true
//isMatch("ab", ".*") → true
//isMatch("aab", "c*a*b") → true
/**
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
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
		// System.out.println(new Solution().isMatch("aaa", "a*.c*."));
		// System.out.println(new Solution().isMatch("aa", "a*"));
		System.out.println(new Solution().isMatch("aaa", ".*"));

		// System.out.println(new Solution().isMatch("aa", "a"));
		// System.out.println("aaa".substring(3));//会报StringIndexOutOfBoundsException
	}

	/**
	 * 这个终于做出来了。。。（最简短的答案没看懂，看的实在心烦了就去自己直接做了， 于是就做出来了。。。还是吃饱了才能看代码。。。）
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (p.equals("")) {
			return s.equals("");
		}
		if (p.length() < 2 || p.charAt(1) != '*') {
			if (s.length() > 0
					&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		} else if (p.length() < 2 || p.charAt(1) == '*') {
			if (p.charAt(0) == '.') {
				for (int i = 0; i <= s.length(); i++) {
					if (isMatch(s.substring(i), p.substring(2))) {
						return true;
					}
				}
			} else {
				int i = 0;
				if (isMatch(s.substring(i), p.substring(2))) {
					return true;
				}
				while (i< s.length() && p.charAt(0) == s.charAt(i)) {
					i++;
					if (isMatch(s.substring(i), p.substring(2))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// private boolean match(char s, char p) {
	// if (s == p || p == '*') {
	// return true;
	// } else {
	// return false;
	// }
	// }
}
