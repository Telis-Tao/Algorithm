package com.leetcode.oj.medium.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
 * 
 * @author Telis
 * 
 */
public class Solution {
	private class Pair {
		int a, b, ap, bp;

		public Pair(int a, int b, int ap, int bp) {
			super();
			this.a = a;
			this.b = b;
			this.ap = ap;
			this.bp = bp;
		}

		@Override
		public String toString() {
			return "[a=" + a + ", b=" + b + ", ap=" + ap + ", bp=" + bp + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// int[] num = { 1, 0, -1, 0, -2, 2 };

		// int[] num = { 2, 1, 0, -1 };
		 int[] num = { -3, -1, 0, 2, 4, 5 };
//		 int[] num = { -493, -482, -482, -456, -427, -405, -392, -385, -351,
//		 -269, -259, -251, -235, -235, -202, -201, -194, -189, -187,
//		 -186, -180, -177, -175, -156, -150, -147, -140, -122, -112,
//		 -112, -105, -98, -49, -38, -35, -34, -18, 20, 52, 53, 57, 76,
//		 124, 126, 128, 132, 142, 147, 157, 180, 207, 227, 274, 296,
//		 311, 334, 336, 337, 339, 349, 354, 363, 372, 378, 383, 413,
//		 431, 471, 474, 481, 492 };
		// int target = 0;
		int target = 2;
		long start = System.currentTimeMillis();
		List<List<Integer>> list = s.fourSum(num, target);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(list);
	}

	private void checkList(List<List<Integer>> list) {
		int first = 0;
		int second = 1;
		while (second < list.size()) {
			if (list.get(first).hashCode() == list.get(second).hashCode()) {
				list.remove(second);
			} else {
				second++;
				first++;
			}
		}
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		if (num.length < 4)
			return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		TreeMap<Integer, ArrayList<Pair>> map = get2SumMap(num);
		// iterMap(map);
		List<List<Integer>> list = makeAList(target, map);
		checkList(list);
		return list;
	}

	private TreeMap<Integer, ArrayList<Pair>> get2SumMap(int[] num) {
		TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
		// 所得结果集
		for (int i = 0; i < num.length; i++) {
			int sum = 0;
			for (int j = i + 1; j < num.length; j++) {
				sum = num[j] + num[i];
				ArrayList<Pair> tempList;
				Pair p = new Pair(num[i], num[j], i, j);
				if (!map.containsKey(sum)) {
					tempList = new ArrayList<>();
				} else {
					tempList = map.get(sum);
				}
				tempList.add(p);
				map.put(sum, tempList);
			}
		}
		return map;
	}

	private List<List<Integer>> makeAList(int target,
			TreeMap<Integer, ArrayList<Pair>> map) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Integer left = map.firstKey();
		Integer right = map.lastKey();
		while (left != null && right != null && left <= right) {
			ArrayList<Pair> leftList;
			ArrayList<Pair> rightList;
			if (left + right == target) {
				leftList = map.get(left);
				rightList = map.get(right);
				int[] result = new int[4];
				if (left == right) {
					for (int i = 0; i < leftList.size(); i++) {
						for (int j = i + 1; j < leftList.size(); j++) {
							if (checkPairs(leftList.get(i), leftList.get(j))) {
								result[0] = leftList.get(i).a;
								result[1] = leftList.get(i).b;
								result[2] = leftList.get(j).a;
								result[3] = leftList.get(j).b;
								Arrays.sort(result);
								list.add(Arrays.asList(result[0], result[1], result[2],
										result[3]));
							}
						}
					}
				} else {
					for (int i = 0; i < leftList.size(); i++) {
						for (int j = 0; j < rightList.size(); j++) {
							if (checkPairs(leftList.get(i), rightList.get(j))) {
								result[0] = leftList.get(i).a;
								result[1] = leftList.get(i).b;
								result[2] = rightList.get(j).a;
								result[3] = rightList.get(j).b;
								Arrays.sort(result);
								list.add(Arrays.asList(result[0], result[1], result[2],
										result[3]));
							}
						}
					}
				}
				left = map.higherKey(left);
			} else if (left + right < target) {
				left = map.higherKey(left);
			} else {
				right = map.lowerKey(right);
			}
		}
		return list;
	}

	private boolean checkPairs(Pair a, Pair b) {
		// TODO Auto-generated method stub
		int[] positions = { a.ap, a.bp, b.ap, b.bp };
		for (int i = 0; i < 2; i++) {
			if (positions[i] == positions[2]||positions[i]==positions[3])
				return false;
		}
		return true;
	}

	private void iterMap(Map<Integer, ArrayList<Pair>> map) {
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int key = it.next();
			System.out.print("key:" + key);
			ArrayList<Pair> list = map.get(key);
			for (Pair p : list) {
				System.out.print(p.toString());
			}
			System.out.println();
		}

	}
}
