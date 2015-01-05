package com.leetcode.oj.easy.remove_element;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
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
//		int[] A = { 1, 2, 3, 3, 1, 2, 3, 1 };
		 int[] A = { 2 };
		int len = s.removeElement(A, 2);
		for (int i = 0; i < len; i++) {
			System.out.print(A[i] + ",");
		}
	}

	public int removeElement(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		int newLen = A.length ;
		for (int i = 0; i <newLen; i++) {
			if (A[i] == elem) {
				A[i--] = A[newLen---1];
			}
		}
		return newLen;
	}
}
