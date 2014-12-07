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
		System.out.println(s.isPalindrome(12332111));
	}

	// public boolean isPalindrome(int x) {
	// char[] c = String.valueOf(x).toCharArray();
	// int lenth = c.length;
	// if(lenth<=1)
	// return true;
	// int halfLenth = (int) Math.floor(lenth/2);
	// for (int i = 0; i < halfLenth; i++) {
	// if(!(c[i]==c[lenth-1-i]))
	// return false;
	// }
	// return true;
	// }
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x < 10)
			return true;
		int left = 0, right = String.valueOf(x).length() - 1;
		while (left < right) {
			if (String.valueOf(x).charAt(left) != String.valueOf(x).charAt(
					right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
