package com.leetcode.oj.medium.swap_nodes_in_pairs;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
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
		int[] num = { 1, 2, 3, 4,5,6 };
		Solution s = new Solution();
		ListNode head = LinkListTools.createLinkedList(num);
		LinkListTools.iterList(head);
		head = s.swapPairs(head);
		LinkListTools.iterList(head);
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode former = head;
		ListNode swap = head;
		while (swap != null && swap.next != null) {
			if (swap == head) {
				swap = former.next;
				former.next = swap.next;
				swap.next = former;
				head = swap;
				swap = former.next;
			} else {
				former.next = swap.next;
				swap.next = former.next.next;
				former.next.next = swap;
				former = swap;
				swap = former.next;
			}
//			LinkListTools.iterList(head);
		}
		return head;
	}
}
