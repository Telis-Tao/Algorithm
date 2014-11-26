package com.leetcode.oj.easy.valid_palindrome;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
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
		// System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(s.isPalindrome("1a2"));
	}

	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		char[] c = new char[s.length()];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char t = s.charAt(i);
			if (Character.isLetterOrDigit(t)) {
				c[count++] = Character.toLowerCase(t);
			} else {
				continue;
			}
		}
		int lenth = count;
		int halfLenth = (int) Math.floor(count / 2);
		for (int i = 0; i < halfLenth; i++) {
			if (!(c[i] == c[lenth - 1 - i]))
				return false;
		}
		return true;
	}
}
