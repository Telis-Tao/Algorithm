package com.leetcode.oj.medium.remove_duplicates_from_sorted_list2;

import com.leetcode.oj.tools.LinkListTools;
import com.leetcode.oj.tools.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
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
		int[] num = { 1,1,2,2,3};
		ListNode head = LinkListTools.createLinkedList(num);
		Solution s = new Solution();
		head = s.deleteDuplicates(head);
		 LinkListTools.iterList(head);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dupHead;
		ListNode dupTail;
		while(head!=null&&head.next!=null&&head.next.val==head.val){
			dupHead = null;
			dupTail = head;
			while(dupTail.next!=null&&dupTail.next.val==head.val){
				dupTail = dupTail.next;
			}
			if(dupTail!=head){
				head = dupTail.next;
			}
		}
		dupTail = null;
		ListNode former = head;
		while (former != null) {
			dupHead = former.next;
			if (dupHead == null) {
				return head;
			}
			if (dupHead.next != null && dupHead.val != dupHead.next.val) {
				dupHead = null;
				former = former.next;
				continue;
			} else {
				if (dupTail == null) {
					dupTail = dupHead.next;
				}
				if (dupTail == null) {
					return head;
				}
				while (dupTail.next != null && dupTail.next.val == dupHead.val) {
					dupTail = dupTail.next;
				}
				former.next = dupTail.next;
				dupHead = null;
				dupTail = null;
			}
//			LinkListTools.iterList(head);
		}
		return head;
	}
}
