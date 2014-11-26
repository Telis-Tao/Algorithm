package com.leetcode.oj.medium.binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.leetcode.oj.easy.binary_tree_level_order_traversal2.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7}, 3 / \ 9 20 / \ 15 7 return
 * its zigzag level order traversal as: [ [3], [20,9], [15,7] ]
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
		Solution s = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> list = s.zigzagLevelOrder(root);
		System.out.println(list);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		zigzagLevelOrder(root, 0, list);
		return list;
	}

	public void zigzagLevelOrder(TreeNode root, int depth,
			List<List<Integer>> list) {
		if (root == null)
			return;
		boolean isLTR = depth % 2 == 0;
		if (list.size() <= depth) {
			if (isLTR) {
				list.add(new ArrayList<Integer>());
			} else {
				list.add(new LinkedList<Integer>());
			}
		}
		if (isLTR) {
			ArrayList<Integer> tempList = (ArrayList<Integer>) list.get(depth);
			tempList.add(root.val);
		} else {
			LinkedList<Integer> tempList = (LinkedList<Integer>) list
					.get(depth);
			tempList.addFirst(root.val);
		}
		zigzagLevelOrder(root.left, depth + 1, list);
		zigzagLevelOrder(root.right, depth + 1, list);
	}
}
