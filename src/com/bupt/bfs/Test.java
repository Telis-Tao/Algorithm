package com.bupt.bfs;

import java.util.List;

import com.leetcode.oj.tools.TreeNode;

public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(6);
		List<TreeNode> list  = BreadthFirstSearch.getList(root);
		System.out.println(list);
	}
}
