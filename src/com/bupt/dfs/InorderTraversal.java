package com.bupt.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.leetcode.oj.tools.TreeNode;

public class InorderTraversal {
	public static void recursive(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		recursive(root.left, list);
		list.add(root);
		recursive(root.right, list);
	}

	public static List<TreeNode> nonRecursive(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left != null) {
				stack.push(node.left);
				node.left = null;
			} else {
				list.add(node);
				stack.pop();
				if (node.right != null) {
					stack.push(node.right);
				}
			}
		}
		return list;
	}
}
