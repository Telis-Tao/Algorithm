package com.leetcode.oj.easy.add_binary;

public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.addBinary("0", "0"));
		 System.out.println(s.addBinary("1111", "1111"));
	}
	public String addBinary(String a, String b) {
		int lenth = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
		char[] ac = toChar(a, lenth);
		char[] bc = toChar(b, lenth);
		int[] sum = new int[lenth];
		for (int i = 0; i < ac.length; i++) {
			sum[i] = ((ac[i] - '0') + (bc[i] - '0'));
		}
		for (int i = sum.length - 1; i >= 0; i--) {
			if (sum[i] >= 2) {
				sum[i] %= 2;
				sum[i - 1] += 1;
			}
		}
		StringBuffer sb = new StringBuffer();
		boolean isZero = true;
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] != 0)
				isZero = false;
			if (!isZero)
				sb.append(sum[i]);
		}
		if (sb.toString().equals(""))
			return "0";
		return sb.toString();
	}

	private char[] toChar(String a, int lenth) {
		char[] ac = new char[lenth];
		int j = 0;
		for (; j < lenth - a.length(); j++) {
			ac[j] = '0';
		}
		for (; j < ac.length; j++) {
			ac[j] = a.charAt(j - (lenth - a.length()));
		}
		return ac;
	}

}
