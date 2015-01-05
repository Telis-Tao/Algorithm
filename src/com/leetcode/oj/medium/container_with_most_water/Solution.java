package com.leetcode.oj.medium.container_with_most_water;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
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
		int[] height = { 1,2,3,3,4,5,6,7,8 };
		Solution s = new Solution();
		System.out.println(s.maxArea(height));
	}

	public int maxArea(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int left,right,max;
		left = 0;
		right = height.length-1;
		max = 0;
		while(left<right){
			max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
			if(height[left]<height[right]){
				left++;
			}else{
				right--;
			}
		}
		return max;
	}
}
