package com.leetcode.oj.hard.edit_distance;

import com.leetcode.oj.tools.ArrayTools;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
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
//		System.out.println(s.minDistance("Telis", "eli"));
//		System.out.println(s.minDistance("a", "b"));
//		System.out.println(s.minDistance("INTENTION ", "EXECUTION"));
		System.out.println(s.minDistance("INT ", "ITC"));
	}

	/**这道题好难。。。虽然最后结果很简单，但是一直没有求出递推公式来。。。
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		int[][] rs = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < rs.length; i++) {
			rs[i][0] = i;
		}
		for (int i = 0; i < rs[0].length; i++) {
			rs[0][i] = i;
		}
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					rs[i + 1][j + 1] = rs[i][j];
				} else {
					int a = rs[i][j + 1];
					int b = rs[i + 1][j];
					rs[i + 1][j + 1] = Math.min(rs[i][j], Math.min(a, b)) + 1;
				}
			}
		}
		 ArrayTools.iter(rs);
		return rs[rs.length - 1][rs[0].length - 1];
	}

}
