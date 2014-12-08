package com.leetcode.oj.medium.combination_sum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü
 * ¡­ ¡Ü ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is:
 * [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 * 
 * @author Telis
 * 
 */
public class Solution {
	List<Integer> result;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.combinationSum2(
				new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
		System.out.println(s.combinationSum2(
				new int[] {  }, 2));
	}

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		result = new ArrayList<Integer>();
		Arrays.sort(num);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		combinationSum2(num, target, list, 0);
		return list;
	}

	public void combinationSum2(int[] num, int target,
			List<List<Integer>> list, int start) {
		if (target == 0) {
			List<Integer> temp = new ArrayList<Integer>(result);
			if(!list.contains(temp)){
				list.add(temp);
			}
		} else {
			for (int i = start; i < num.length; i++) {
				if (target < num[i]) {
					break;
				}
				result.add(num[i]);
				combinationSum2(num, target - num[i], list, i+1);
				result.remove(result.size() - 1);
			}
		}
	}
}
