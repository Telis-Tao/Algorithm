package com.leetcode.oj.easy.string_to_integer;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
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
		// System.out.println(s.atoi("123456789012349"));
		// System.out.println(s.atoi("-123"));
		// System.out.println(s.atoi("+1"));
		// System.out.println(s.atoi("    -010"));
		// System.out.println(s.atoi("  -0012a42"));
		// System.out.println(s.atoi("-2147483648"));
		System.out.println(s.atoi("123 465"));
	}

	public int atoi(String str) {
		String reg = "^\\s*[-+]?[0-9]+.*";
		if (!str.matches(reg)) {
			return 0;
		}
		str = str.trim();
		char[] c = str.toCharArray();
		int i = 0;
		if (c[0] == '-' || c[0] == '+')
			i = 1;
		for (; i < c.length; i++) {
			if (!(c[i] >= '0' && c[i] <= '9'))
				break;
		}
		char[] cNext = new char[i];
		for (int j = 0; j < cNext.length; j++) {
			cNext[j] = c[j];
		}
		str = String.valueOf(cNext);
		try {
			return Integer.valueOf(str);
		} catch (NumberFormatException e) {
			if (c[0] == '-')
				return Integer.MIN_VALUE;
			else
				return Integer.MAX_VALUE;
		}
	}
}
