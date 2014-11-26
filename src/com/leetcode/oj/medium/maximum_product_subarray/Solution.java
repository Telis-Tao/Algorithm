package com.leetcode.oj.medium.maximum_product_subarray;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
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
		// int[] A = {2,3,-2,4};
		// int[] A =
		// {-5,2,4,1,-2,2,-6,3,-1,-1,-1,-2,-3,5,1,-3,-4,2,-4,6,-1,5,-6,1,-1,-1,1,1,-1,1,1,-1,-1,1};
		// int[] A = { -2, -3, 7 };
		// int[] A = {0,2};
		// int[] A = { -2, 3, -4 };
		int[] A = { 2, -5, -2, -4, 3 };
		Solution s = new Solution();
		System.out.println(s.maxProduct(A));
	}

	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = A[0], min = A[0], result = A[0];
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
			if (max > result) {
				result = max;
			}
			System.out.println("max:"+max+"\tmin:"+min);
		}
		return result;
		//-----------------------------------------------
//		int r = A[0];
//
//	    // imax/imin stores the max/min product of
//	    // subarray that ends with the current number A[i]
//	    for (int i = 1, imax = r, imin = r; i < A.length; i++) {
//	        // multiplied by a negative makes big number smaller, small number bigger
//	        // so we redefine the extremums by swapping them
//	        if (A[i] < 0)
//	            swap(imax, imin);
//
//	        // max/min product for the current number is either the current number itself
//	        // or the max/min by the previous number times the current one
//	        imax = Math.max(A[i], imax * A[i]);
//	        imin = Math.min(A[i], imin * A[i]);
//
//	        // the newly computed max value is a candidate for our global result
//	        r = Math.max(r, imax);
//	    }
//	    return r;
	}
}
