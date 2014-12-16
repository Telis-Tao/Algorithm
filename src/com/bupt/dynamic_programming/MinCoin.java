package com.bupt.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够n元?
 * 
 * @author Telis
 * 
 */
public class MinCoin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCoin s = new MinCoin();
		s.getSolution(11);
	}

	public int getSolution(int n) {
		int[] results = new int[n + 1];
		results[0] = 0;
		results[1] = 1;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<Integer>());
		}
		list.get(1).add(1);
		for (int i = 2; i < results.length; i++) {
			int min = n;
			int count = 5;
			int pos = i;
			for (int j = 0; j < i; j++) {
				int temp = i - j;
//				System.out.println(temp);
				if (temp == 1 || temp == 3 || temp == 5) {
					if (min >= results[j] + 1) {
						min = results[j] + 1;
						count = temp;
						pos = j;
//						System.out.println("min:" + min + " count:" + count);
					}
				}
			}
			list.get(i).add(count);
			list.get(i).addAll(list.get(pos));
			results[i] = min;
		}
		System.out.println(Arrays.toString(results));
		System.out.println(list);
		return 0;
	}
}
