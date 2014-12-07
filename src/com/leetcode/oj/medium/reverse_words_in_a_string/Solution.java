package com.leetcode.oj.medium.reverse_words_in_a_string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * click to show clarification.
 * 
 * Clarification: What constitutes a word? A sequence of non-space characters
 * constitutes a word. Could the input string contain leading or trailing
 * spaces? Yes. However, your reversed string should not contain leading or
 * trailing spaces. How about multiple spaces between two words? Reduce them to
 * a single space in the reversed string.
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

//		System.out.println(s.reverseWords("   the   sky   is    blue   "));
		System.out.println(s.reverseWords("dsad"));
	}

	public String reverseWords(String s) {
		s = s.trim();
		s = s.replaceAll("[ ]+", " ");
		String result = "";
		for (int i = s.length(); i >= 0; i--) {
			int j = i - 1;
			while (j >= 0 && s.charAt(j) != ' ') {
				j--;
			}
			result += s.substring(j+1, i)+" ";
			i = j + 1;
		}
		return result.substring(0, result.length()-1);
	}
}
