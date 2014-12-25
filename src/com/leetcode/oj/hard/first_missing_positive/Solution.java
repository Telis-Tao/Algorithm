package com.leetcode.oj.hard.first_missing_positive;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int result = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new Solution().firstMissingPositive(new int[] { 1, 2, 3, 4, 5 });
		// new Solution().firstMissingPositive(new int[] { 1 });
		new Solution().firstMissingPositive(new int[] {});
		// new Solution().firstMissingPositive(new int[] { 2, 3, 4 });
		// new Solution().firstMissingPositive(new int[] { 1, 2, 3, 4, 5, 6 });
		// new Solution().firstMissingPositive(new int[] { 1, 1, 1, 1, 1, 1, 1
		// });
	}

	public int firstMissingPositive(int[] A) {
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				A[index++] = A[i];
			}
		}
		// System.out.println(Arrays.toString(A) + " : " + index);
		// A��[0,index-1]Ϊ����
		// ȫ��ɸ���
		for (int i = 0; i < index; i++) {
			A[i] = -A[i];
		}
		// System.out.println(Arrays.toString(A));
		// ���Ĳ��֣�
		// ���A[i]��ֵ����[1,index]֮�䣬��ô����Ӧλ���ϵ�A[i]�������
		for (int i = 0; i < index; i++) {
			int temp = Math.abs(A[i]);
			if (temp > 0 && temp <= index) {
				if (A[temp - 1] < 0)
					A[temp - 1] = -A[temp - 1];
			}
		}
		// ��һ�����ֵĸ����������iλ��+1��Ϊ������ֵ������������û�У���ô��˵�����û������������ֵΪindex+1
		for (int i = 0; i < index; i++) {
			if (A[i] < 0) {
				// System.out.println(i + 1);
				return i + 1;
			}
		}
		return index + 1;
	}

}