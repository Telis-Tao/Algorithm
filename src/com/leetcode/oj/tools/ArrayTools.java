package com.leetcode.oj.tools;

public class ArrayTools {
	public static void iter(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
