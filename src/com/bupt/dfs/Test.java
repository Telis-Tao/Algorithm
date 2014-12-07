package com.bupt.dfs;

import java.util.ArrayList;
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
		List<TreeNode> list;
		// System.out.println("PreorderTraversal£º");
		// List<TreeNode> list = new ArrayList<TreeNode>();
		// PreorderTraversal.recursive(root, list);
		// System.out.println(list);
		// list = PreorderTraversal.nonRecursive(root);
		// System.out.println(list);
//		System.out.println("InorderTraversal:");
//		list = new ArrayList<TreeNode>();
//		InorderTraversal.recursive(root, list);
//		System.out.println(list);
//		list = InorderTraversal.nonRecursive(root);
//		System.out.println(list);
		System.out.println("PostorderTraversal:");
		list = new ArrayList<TreeNode>();
		PostorderTraversal.recursive(root, list);
		System.out.println(list);
		list = PostorderTraversal.nonRecursive(root);
		System.out.println(list);
	}
}
