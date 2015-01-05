package com.leetcode.oj.medium.next_permutation;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 ¡ú 1,3,2 3,2,1 ¡ú
 * 1,2,3 1,1,5 ¡ú 1,5,1 n=1:1234
 * 
 * @author Telis
 * 
 */
// n=1:1234
// n=2:1243
// n=3:1324
// n=4:1342
// n=5:1423
// n=6:1432
// n=7:2134
// n=8:2143
// n=9:2314
// n=10:2341
// n=11:2413
// n=12:2431
// n=13:3124
// n=14:3142
// n=15:3214
// n=16:3241
// n=17:3412

// n=1:12345
// n=2:12354
// n=3:12435
// n=4:12453
// n=5:12534
// n=6:12543
// n=7:13245
// n=8:13254
// n=9:13425

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.nextPermutation(new int[] { 1, 2, 3 });
		s.nextPermutation(new int[] { 1, 2, 3, 4, 5 });
		s.nextPermutation(new int[] { 5, 4, 7, 5, 3, 2 });
		s.nextPermutation(new int[] { 1, 2 });
		s.nextPermutation(new int[] { 1, 3, 2 });
		s.nextPermutation(new int[] { 2, 3, 1 });
		s.nextPermutation(new int[] { 3, 2, 1 });
	}

	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1)
			return;
		int min = 0, min2 = 0;
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				min = i - 1;
				break;
			}
		}
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[min]) {
				min2 = i;
				break;
			}
		}
		// System.out.println("min:" + min + " min2:" + min2);
		swap(num, min, min2);
		// System.out.println(Arrays.toString(num));
		int left = min + 1;
		if (min2 == 0) {
			left = 0;
		}
		int right = num.length - 1;
		while (left < right) {
			swap(num, left, right);
			left++;
			right--;
		}
		// System.out.println(Arrays.toString(num));
	}

	private void swap(int[] num, int min, int min2) {
		// TODO Auto-generated method stub
		int temp = num[min];
		num[min] = num[min2];
		num[min2] = temp;
	}
}
