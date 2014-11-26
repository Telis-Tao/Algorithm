package com.leetcode.oj.medium.partition_list;

import com.leetcode.oj.easy.remove_duplicates_from_sorted_list.ListNode;
import com.leetcode.oj.tools.LinkListTools;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
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
		// int[] vals = { 4, 19, 14, 5, -3, 1, 8, 5, 11, 15 };
		// int[] vals = { 2, 1 };
		int[] vals = { 1, 2 };
		ListNode head = LinkListTools.createLinkedList(vals);
		head = s.partition(head, 3);
		LinkListTools.iterList(head);
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;
		LinkListTools.iterList(head);
		ListNode small = head;
		ListNode big = head;
		ListNode temp = head;
		while (temp != null) {
			if (temp.val >= x) {
				big = temp;
				break;
			}
			small = temp;
			temp = temp.next;
		}
		if(big.val<x)
			return head;
		ListNode former = big;
		ListNode next = big.next;
		ListNode waitHead = null;
		ListNode waitLast = null;
		
		while (next != null) {
			if (next.val < x) {
				former.next = next.next;
				if (waitHead == null) {
					waitHead = next;
					waitLast = waitHead;
				} else {
					waitLast.next = next;
					waitLast = waitLast.next;
					waitLast.next = null;
				}
				next = former.next;
			} else {
				former = next;
				next = next.next;
			}
		}
		if (waitHead == null) {
			return head;
		}
		if (big == head) {
			waitLast.next = head;
			head = waitHead;
		} else {
			waitLast.next = big;
			small.next = waitHead;
		}
		return head;
	}
}
