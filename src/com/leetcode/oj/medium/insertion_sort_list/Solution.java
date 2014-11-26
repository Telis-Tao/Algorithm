package com.leetcode.oj.medium.insertion_sort_list;

import com.leetcode.oj.easy.remove_duplicates_from_sorted_list.ListNode;
import com.leetcode.oj.tools.LinkListTools;

/**
 * Sort a linked list using insertion sort.
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
		int[] vals = { 4, 19, 14, 5, -3, 1, 8, 5, 11, 15 };
		// int[] vals = { 1, 2 };
		ListNode head = new ListNode(0);
		ListNode temp = head;
		for (int i = 0; i < vals.length; i++) {
			temp.next = new ListNode(vals[i]);
			temp = temp.next;
		}
		head = head.next;
		head = s.insertionSortList(head);
		LinkListTools.iterList(head);
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode sortedNode = head.next;
		ListNode formerNode = head;
		while (sortedNode != null) {
			if (formerNode.val <= sortedNode.val) {
				formerNode = sortedNode;
				sortedNode = sortedNode.next;
			} else {
				ListNode miner = head;
				while (miner.next.val < sortedNode.val) {
					miner = miner.next;
				}
				if (miner.val > sortedNode.val) {
					formerNode.next = sortedNode.next;
					sortedNode.next = head;
					head = sortedNode;
					sortedNode = formerNode.next;
				} else {
					formerNode.next = sortedNode.next;
					sortedNode.next = miner.next;
					miner.next = sortedNode;
					sortedNode = formerNode.next;
				}
			}
			printNode(head, sortedNode, formerNode);
		}
		return head;
	}

	private void printNode(ListNode head, ListNode sortedNode,
			ListNode formerNode) {
		System.out.print("" + formerNode.val + "\t");
		if (sortedNode != null)
			System.out.print("" + sortedNode.val + "\t");
		LinkListTools.iterList(head);
	}
}
