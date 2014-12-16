package com.leetcode.oj.hard.trapping_rain_water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
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
		System.out.println(s.trap(new int[] { 1, 0, 1 }));
		System.out.println(s.trap(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));
		System.out.println(s.trap(new int[] { 5, 2, 1, 2, 1, 5 }));
		System.out.println(s.trap(new int[] { 5, 5, 1, 7, 5, 5, 5, 2, 7, 7 }));
		System.out.println(s.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2,
				1 }));
	}

	/**
	 * 这个是看了DISCUSS的思路后自己编的，果然想法还是不够，有差距
	 * 
	 * @param A
	 * @return
	 */
	public int trap(int[] A) {
		if (A.length < 3) {
			return 0;
		}
		int left = 0;
		int right = A.length - 1;
		while (left < right && A[left] < A[left + 1]) {
			left++;
		}
		while (left < right && A[right] < A[right - 1]) {
			right--;
		}
		int sum = 0;
		int min = Math.min(A[left], A[right]);
		while (left < right) {
			while (left < right && min >= A[left]) {
				sum += min - A[left++];
				// results[left] = A[left] - min;
			}
			min = Math.min(A[left], A[right]);
			while (left < right && min >= A[right]) {
				sum += min - A[right--];
				// results[right] = A[right] - min;
			}
			min = Math.min(A[left], A[right]);
		}
		return sum;
	}
	// 这是自己编写的，通过找最大值、次最大值实现的方法，需要O(n)的时间，O(n)的空间
	// public int trap(int[] A) {
	// if (A.length < 3) {
	// return 0;
	// }
	// TreeMap<Integer, List<Integer>> map = new TreeMap<>();
	// // System.out.println(Arrays.toString(A));
	// int[] results = new int[A.length];
	// if (A[0] > A[1]) {
	// List<Integer> list = new ArrayList<Integer>();
	// list.add(0);
	// map.put(A[0], list);
	// }
	// if (A[A.length - 1] > A[A.length - 2]) {
	// if (map.containsKey(A[A.length - 1])) {
	// map.get(A[A.length - 1]).add(A.length - 1);
	// } else {
	// List<Integer> list = new ArrayList<Integer>();
	// list.add(A.length - 1);
	// map.put(A[A.length - 1], list);
	// }
	// }
	// for (int i = 1; i < A.length - 1; i++) {
	// if (A[i] >= A[i - 1] && A[i] >= A[i + 1]) {
	// if (map.containsKey(A[i])) {
	// map.get(A[i]).add(i);
	// } else {
	// List<Integer> list = new ArrayList<Integer>();
	// list.add(i);
	// map.put(A[i], list);
	// }
	// }
	// }
	// // System.out.println(map);
	// // while (!map.isEmpty()) {
	// // System.out.println(A[findNextMax(map)]);
	// // }
	// int max = findNextMax(map);
	// int nextMax = findNextMax(map);
	// while (nextMax != -1) {
	// // System.out.println(max+":"+nextMax);
	// int left = Math.min(nextMax, max);
	// int right = Math.max(nextMax, max);
	// for (int i = left; i <= right; i++) {
	// if (results[i] == 0) {
	// results[i] = A[nextMax];
	// }
	// }
	// max = nextMax;
	// nextMax = findNextMax(map);
	// }
	// // System.out.println(Arrays.toString(results));
	// int sum = 0;
	// for (int i = 0; i < results.length; i++) {
	// if (results[i] - A[i] > 0)
	// sum += results[i] - A[i];
	// }
	// return sum;
	// }
	//
	// private int findNextMax(TreeMap<Integer, List<Integer>> map) {
	// if (map.isEmpty()) {
	// return -1;
	// }
	// // TODO Auto-generated method stub
	// int key = map.lastKey();
	// List<Integer> list = map.get(key);
	// int max = list.get(list.size() - 1);
	// list.remove(list.size() - 1);
	// if (list.isEmpty()) {
	// map.remove(key);
	// }
	// return max;
	// }

}
