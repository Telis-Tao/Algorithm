package com.leetcode.oj.easy.valid_number;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isNumber("0"));
		System.out.println(s.isNumber("0.1"));
		System.out.println(s.isNumber("abc"));
		System.out.println(s.isNumber("1 a"));
		System.out.println(s.isNumber("2e10"));
		System.out.println(s.isNumber("3 "));
		System.out.println(s.isNumber("46.e3"));
		System.out.println(s.isNumber(".1"));
		System.out.println(s.isNumber(".2e81"));
		System.out.println(s.isNumber("3."));
		System.out.println(s.isNumber("e9"));
	}

	public boolean isNumber(String s) {
		s = s.trim();
		if (s == null)
			return false;
		if(s.equals(""))
			return false;
		boolean isNumber = s.matches("[+-]?\\d+|[+-]?\\d*\\.\\d+|[+-]?\\d+\\.\\d*|[+-]?\\d*\\.?\\d*e\\d+");
		return isNumber;
	}
}
