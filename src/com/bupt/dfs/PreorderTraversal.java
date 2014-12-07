package com.bupt.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.tools.TreeNode;

public class PreorderTraversal {

	public static void recursive(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		recursive(root.left, list);
		recursive(root.right, list);
	}

	public static List<TreeNode> nonRecursive(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}
}
