package com.leetcode.oj.tools;


public class TreeTools {
	public static void firstPrint(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.val);
		firstPrint(root.left);
		firstPrint(root.right);
	}
}
