package com.leetcode.oj.hard.distinct_subsequences;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// System.out.println(s.numDistinct("aabb", "abb"));
		System.out.println(s.numDistinct("eee", "eee"));
		// System.out.println(s.numDistinct("rabbbit", "rabbit"));
	}

	/**
	 * ����о�Ҳ�Ƚ��Ѱ���������һ����Ƴ�����ʽ�ˣ�̫��ϧ�ˣ���������Ż���һ�£��ռ临�Ӷ�ֻ��O(n),���㸴�Ӷ���O(n*m)(��ʵ���Խ�һ���Ż���
	 * ����Ϊ������һЩ�ط���ȻΪ0(�Ѿ��Ż�))
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public int numDistinct(String S, String T) {
		if (T.length() < 1 || S.length() < 1)
			return 0;
		if (S.length() < T.length())
			return 0;
		int[] former = new int[S.length() + 1];
		int[] results = new int[S.length() + 1];
		for (int i = 0; i < former.length; i++) {
			former[i] = 1;
		}
		for (int i = 1; i <= T.length(); i++) {
			for (int j = i; j < results.length; j++) {
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					results[j] = results[j - 1] + former[j - 1];
				} else {
					results[j] = results[j - 1];
				}
			}
			for (int j = 0; j < results.length; j++) {
				former[j] = results[j];
				results[j] = 0;
			}
		}
		return former[former.length - 1];
	}

}
