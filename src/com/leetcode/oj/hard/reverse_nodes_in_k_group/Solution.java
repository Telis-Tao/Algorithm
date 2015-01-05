package com.leetcode.oj.hard.reverse_nodes_in_k_group;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
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
		ListNode head = LinkListTools.createLinkedList(new int[] { 1, 2 });
		LinkListTools.iterList(head);
		Solution s = new Solution();
		head = s.reverseKGroup(head, 2);
		LinkListTools.iterList(head);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2) {
			return head;
		}
		if (!isEnough(head, k-1)) {
			return head;
		}

		// System.out.println(head.val);
		ListNode node;
		int count;
		count = 1;
		node = head;
		while (count++ < k) {
			ListNode temp = node.next;
			node.next = temp.next;
			temp.next = head;
			head = temp;
		}
		// LinkListTools.iterList(head);
		// System.out.println(node.val);
		// System.out.println(node.next.val);
		while (isEnough(node, k)) {
			count = 1;
			ListNode temp = node.next;
			while (temp.next != null && count++ < k) {
				ListNode next = temp.next;
				// System.out.println(temp +" "+ next);
				temp.next = next.next;
				next.next = node.next;
				node.next = next;
				// LinkListTools.iterList(head);
			}
			count = 0;
			while (count++ < k) {
				node = node.next;
			}
			// LinkListTools.iterList(head);
		}
		return head;
	}

	private boolean isEnough(ListNode head, int k) {
		if (head == null)
			return false;
		ListNode node = head.next;
		// System.out.println(head.val);
		// Õë¶Ôhead²¿·Ö
		int count = 1;
		while (count < k) {
			if (node != null) {
				// System.out.println(node.val);
				node = node.next;
				count++;
			} else {
				return false;
			}
		}
		if (node != null) {
			return true;
		}
		return false;
	}
}
