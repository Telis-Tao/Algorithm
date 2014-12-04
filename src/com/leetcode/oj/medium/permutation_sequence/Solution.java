package com.leetcode.oj.medium.permutation_sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[] results;
	int[] used;
	int seq;
	String result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		for (int i = 1; i < 10; i++) {
			System.out.println("n=" + i + ":" + s.getPermutation(5, i));
		}
		// System.out.println("n=" + 17 + ":" + s.getPermutation(4, 1));
	}

	// 另外一个版本的求解，但是数量大求不出来。
	// public String getPermutation(int n, int k) {
	// results = new int[n];
	// used = new int[n];
	// result = "";
	// seq = 0;
	// getPermutation(n, k, 0);
	// // System.out.println(Arrays.toString(results));
	// // System.out.println(result);
	// return result;
	// }
	//
	// public void getPermutation(int n, int k, int count) {
	// if (count == n) {
	// seq++;
	// if (seq == k) {
	// for (int i = 0; i < results.length; i++) {
	// result += results[i];
	// }
	// return;
	// }
	// } else {
	// if(seq<k){
	// for (int i = 0; i < n; i++) {
	// if (used[i] == 0) {
	// results[count] = i + 1;
	// used[i] = 1;
	// getPermutation(n, k, count + 1);
	// used[i] = 0;
	// }
	// }
	// }
	// }
	// }
	public String getPermutation(int n, int k) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += i + 1;
		}
		char[] c = new char[n];
		int i = n;
		while (i > 0) {
			int plus = 1;
			for (int j = 1; j < i; j++) {
				plus *= j;
			}
			int count = 0;
			if (k > 1) {
				for (int j = 0; j < str.length(); j++) {
					if (k > (j * plus) && k <= ((j + 1) * plus)) {
						count = j;
						break;
					}
				}
			}
			c[n - i] = str.charAt(count);
			k = k - plus * count;
			// System.out.println("count:" + count+" k:" + k);
			str = str.replace(String.valueOf(str.charAt(count)), "");
			i--;
		}
		return String.valueOf(c);
	}

}
