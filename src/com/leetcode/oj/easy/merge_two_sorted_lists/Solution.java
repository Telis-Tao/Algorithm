package com.leetcode.oj.easy.merge_two_sorted_lists;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
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
		ListNode head1 = LinkListTools.createLinkedList(new int[]{1,2,3});
		ListNode head2 = LinkListTools.createLinkedList(new int[]{4,6,7});
		LinkListTools.iterList(s.mergeTwoLists(head1, head2));

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		// L2的小于头节点的情况：
		if (temp2.val < l1.val) {
			while (temp2.next != null && temp2.next.val < l1.val) {
				temp2 = temp2.next;
			}
			ListNode temp = temp2.next;
			temp2.next = l1;
			l1 = l2;
			temp1 = l1;
			temp2 = temp;
		}
		// 处理常规的情况
		while (temp1.next != null && temp2 != null) {
			if (temp1.next.val > temp2.val) {
				ListNode temp = temp2;
				temp2 = temp2.next;
				temp.next = temp1.next;
				temp1.next = temp;
			} else {
				temp1 = temp1.next;
			}
		}
		if(temp1.next==null){
			temp1.next = temp2;
		}
		return l1;
	}
}
