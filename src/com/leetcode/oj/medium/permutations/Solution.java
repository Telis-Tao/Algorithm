package com.leetcode.oj.medium.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author Telis
 * 
 */
public class Solution {
	int[] result;
	int[] used;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.permute(new int[] { 1, 2, 3 }));
		System.out.println(s.permute(new int[] { 1}));
		System.out.println(s.permute(new int[] {}));
		System.out.println(s.permute(new int[] { 1, 2, 3 }));
	}

	public List<List<Integer>> permute(int[] num) {
		result = new int[num.length];
		used = new int[num.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		permute(num, 0, list);
		return list;
	}

	public void permute(int[] num, int count, List<List<Integer>> list) {
		if (count == num.length) {
//			System.out.println(Arrays.toString(result));
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < result.length; i++) {
				temp.add(result[i]);
			}
			list.add(temp);
		} else {
			for (int i = 0; i < num.length; i++) {
				if (used[i] == 0) {
					used[i] = 1;
					result[count] = num[i];
					permute(num, count + 1, list);
					used[i] = 0;
				}
			}
		}
	}
}
