package com.leetcode.oj.easy.reverse_integer;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int i = s.reverse(-901000);
		System.out.println(i);
	}

	public int reverse(int x) {
		char[] c = String.valueOf(x).toCharArray();
		boolean isNeg = false;
		if (c[0] == '-') {
			isNeg = true;
			String tempStr = String.valueOf(x).substring(1);
			c = tempStr.toCharArray();
		}
		char temp;
		int lenth = c.length;
		int half = (int) Math.floor(lenth / 2);
		for (int i = 0; i < half; i++) {
			temp = c[i];
			c[i] = c[lenth - i - 1];
			c[lenth - i - 1] = temp;
		}
		if (isNeg) {
			char[] cNeg = new char[c.length + 1];
			cNeg[0] = '-';
			for (int i = 1; i < cNeg.length; i++) {
				cNeg[i] = c[i - 1];
			}
			return Integer.valueOf(new String(cNeg));
		}
		return Integer.valueOf(new String(c));
	}
}
