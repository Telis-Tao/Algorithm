package com.leetcode.oj.easy.single_number;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] A = { 1, 2, 3, 4, 5, 7, 1, 2, 3, 4, 5 };
		// int single = s.singleNumberWithoutMemory(A);
		// System.out.println(single);
		System.out.println(1 ^ 2);
		System.out.println(2 ^ 3);
	}

	/**
	 * 此版本需要有額外的内存空間
	 * 
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : A) {
			Integer temp = map.put(i, 1);
			if (temp != null && temp == 1)
				map.put(i, 2);

		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> it = set.iterator();
		while (it.hasNext()) {
			Entry<Integer, Integer> temp = it.next();
			if (temp.getValue() == 1)
				return temp.getKey();
		}
		return 0;

	}

	public int singleNumberWithoutMemory(int[] A) {
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result ^= A[i];
			System.out.println(result);
		}

		return result;
	}
}
