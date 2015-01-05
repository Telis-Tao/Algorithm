package com.leetcode.oj.medium.sum_root_to_leaf_numbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.oj.tools.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 * root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25
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
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(6);
		Solution s = new Solution();
		System.out.println(s.sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		LinkedList<String> linkList = new LinkedList<>();
		List<Integer> list = new ArrayList<Integer>();
		sumNumbers(root, linkList, list);
//		System.out.println(list);
		Iterator<Integer> it = list.iterator();
		int result = 0;
		while(it.hasNext()){
			result += it.next();
		}
		return result;
	}

	public void sumNumbers(TreeNode root, LinkedList<String> linkList,
			List<Integer> list) {
		if (root.left == null && root.right == null) {
			Iterator<String> it = linkList.iterator();
			String value = "";
			while (it.hasNext()) {
				value += it.next();
			}
			value += root.val;
			list.add(Integer.parseInt(value));
		} else {
			linkList.add(String.valueOf(root.val));
			if (root.left != null) {
				sumNumbers(root.left, linkList, list);
			}
			if (root.right != null) {
				sumNumbers(root.right, linkList, list);
			}
			linkList.removeLast();
		}
	}
}
