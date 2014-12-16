package com.leetcode.oj.hard.N_Queens2;

import java.util.ArrayList;
import java.util.List;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[] results;
	int result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().totalNQueens(8));
	}

	public int totalNQueens(int n) {
		results = new int[n];
		result = 0;
		solveNQueens(n, 0);
		// System.out.println(list);
		return result;
	}

	public void solveNQueens(int n, int count) {
		if (count == n) {
			result++;
			// for (int i = 0; i < strs.length; i++) {
			// System.out.println(strs[i]);
			// }
			// System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				results[count] = i;
				if (isAvailable(count)) {
					solveNQueens(n, count + 1);
				}
			}
		}

	}

	/**
	 * �ж��Ƿ����ǰ�Ļʺ��г�ͻ(��results�����λ�ã�i����ڼ��У���������ִ���ڼ���)
	 * 
	 * @param count
	 *            �ڼ����ʺ�
	 * @return
	 */
	private boolean isAvailable(int count) {
		// TODO Auto-generated method stub
		for (int i = 0; i < count; i++) {
			// �Ƿ���ͬһ��
			if (results[i] == results[count]) {
				return false;
			}
			// �Ƿ�б�Ż�����
			if (Math.abs(results[i] - results[count]) == Math.abs(i - count)) {
				return false;
			}
		}
		return true;
	}
}
