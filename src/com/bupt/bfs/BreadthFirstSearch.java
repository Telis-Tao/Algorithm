package com.bupt.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.leetcode.oj.tools.TreeNode;

public class BreadthFirstSearch {
	public static List<TreeNode> getList(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		LinkedList<TreeNode> link = new LinkedList<TreeNode>();
		link.add(root);
		while (!link.isEmpty()) {
			TreeNode node = link.pop();
			list.add(node);
			if (node.left != null) {
				link.add(node.left);
			}
			if (node.right != null) {
				link.add(node.right);
			}
		}
		return list;
	}
}
