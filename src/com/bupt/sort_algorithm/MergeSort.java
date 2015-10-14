package com.bupt.sort_algorithm;

import java.util.Arrays;

public class MergeSort {
	private int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort m = new MergeSort();
//		m.sort(new int[] { 3, 1, 4, 5, 9, 2, 6, 7 });
		m.sort(new int[] { 1, 7, 2, 9, 6, 4, 5, 3 });
		// int[] temp = new int[4];
		// m.mergeSort(new int[] { 1, 3, 2, 4 }, 0, 4, temp);
		// System.out.println(Arrays.toString(temp));
	}

	public void sort(int[] nums) {
		int[] result = new int[nums.length];
		sort(nums, 0, result.length - 1, result);
		System.out.println(Arrays.toString(result));
		System.out.println(count);
	}

	private void sort(int[] nums, int start, int end, int[] result) {
		if (start < end) {
			int half = (start + end) / 2;
			// System.out.println(start + " " + half + " " + end);
			sort(nums, start, half, result);
			sort(nums, half + 1, end, result);
			mergeSort(nums, start, end, result);
		}
	}

	// ���Ѿ����������������Խ��е�����
	public void mergeSort(int[] nums, int start, int end, int[] temp) {
		int half = (start + end) / 2;
		int left = start;
		int right = half + 1;
		int current = start;
		String str  = "";
		// System.out.println("mergeSort:" + start + " " + half + " " + end);
		while (left <= half && right <= end) {
			if (nums[left] > nums[right]) {
				count += half - left + 1;
				temp[current++] = nums[right++];
			} else {
				temp[current++] = nums[left++];
			}
			// System.out.println(Arrays.toString(temp));
		}
		while (left <= half) {
//			 count += half - left + 1;
			temp[current++] = nums[left++];
		}
		while (right <= end) {
			temp[current++] = nums[right++];
		}
		for (int i = start; i <= end; i++) {
			nums[i] = temp[i];
		}
		// System.out.println(Arrays.toString(temp));
	}
}
