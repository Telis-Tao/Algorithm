package com.leetcode.oj.easy.intersection_of_two_linked_lists;

import com.leetcode.oj.tools.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A: a1 ¡ú a2 ¨K c1 ¡ú c2 ¡ú c3 ¨J B: b1 ¡ú b2 ¡ú b3 begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory.
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
		ListNode root1 = new ListNode(1);
		root1.next = new ListNode(2);
		ListNode root2 = new ListNode(2);
		root1.next.next = new ListNode(3);
		root2.next = root1.next.next;
		ListNode result = new Solution().getIntersectionNode(root1, root2);
		System.out.println(result.val);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int aLenth = 0;
		int bLenth = 0;
		ListNode temp = headA;
		while (temp != null) {
			temp = temp.next;
			aLenth++;
		}
		temp = headB;
		while (temp != null) {
			temp = temp.next;
			bLenth++;
		}
		while (aLenth != bLenth) {
			if (aLenth > bLenth) {
				headA = headA.next;
				aLenth--;
			} else {
				headB = headB.next;
				bLenth--;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				return headA;
			} else {
				headA = headA.next;
				headB = headB.next;
			}
		}
		return null;
	}

}
