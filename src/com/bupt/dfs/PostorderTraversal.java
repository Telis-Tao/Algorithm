package com.bupt.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;

public class PostorderTraversal {
	public static void recursive(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		recursive(root.left, list);
		recursive(root.right, list);
		list.add(root);
	}

	public static List<TreeNode> nonRecursive(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left == null && node.right == null) {
				list.add(node);
				stack.pop();
			} else {
				if (node.right != null) {
					stack.push(node.right);
					node.right = null;
				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
			}
		}
		return list;
	}
}
