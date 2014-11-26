package com.leetcode.oj.tools;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;

public class TreeTools {
	public static void firstPrint(TreeNode root){
		if(root==null)
			return;
		System.out.println(root.val);
		firstPrint(root.left);
		firstPrint(root.right);
	}
}
