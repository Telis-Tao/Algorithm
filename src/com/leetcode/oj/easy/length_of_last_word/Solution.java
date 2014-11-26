package com.leetcode.oj.easy.length_of_last_word;

public class Solution {
	public static void main(String args[]) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLastWord("Helllllo World"));
		System.out.println(s.lengthOfLastWord("World"));
		System.out.println(s.lengthOfLastWord("a "));
	}

	public int lengthOfLastWord(String s) {
		s=s.trim();
		if(s.length()==0)
			return 0;
		char[] c = s.toCharArray();
		int i = c.length - 1;
		for (; i >= 0; i--) {
			if (c[i] == ' ')
				break;
		}
		return c.length-i-1 ;
	}
}
