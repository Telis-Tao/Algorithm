package com.leetcode.oj.easy.palindrome_number;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
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
		System.out.println(s.isPalindrome(1233221));
	}

	public boolean isPalindrome(int x) {
		char[] c = String.valueOf(x).toCharArray();
		int lenth = c.length;
		if(lenth<=1)
			return true;
		int halfLenth = (int) Math.floor(lenth/2);
		for (int i = 0; i < halfLenth; i++) {
			if(!(c[i]==c[lenth-1-i]))
				return false;
		}
		return true;
	}
}
