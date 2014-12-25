package com.leetcode.oj.hard.copy_list_with_random_pointer;

import java.util.HashMap;

import com.leetcode.oj.tools.RandomListNode;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
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
		RandomListNode head = RandomListNode.createRandomListNode(new int[] {
				1, 2, 3, 4, 5 });
		// RandomListNode head = RandomListNode.createRandomListNode(new int[] {
		// -1 });
		new Solution().copyRandomList(head);
	}

	/**
	 * 这个题果然还是得用HashMap来做。。。现在做题陷入一个陷阱，就是很不想用空间复杂度很高的类来提升计算效率，
	 * 导致了很多题都不知道该怎么做，感觉还是要先实现、再考虑效率比较好
	 * 
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		// head.next.next.random = head.next;//for test
		// RandomListNode.printList(head);
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode node = head;
		RandomListNode root = new RandomListNode(head.label);
		RandomListNode rootNext = root;
		map.put(node, root);
		node = head;
		while (node.next != null) {
			rootNext.next = new RandomListNode(node.next.label);
			map.put(node.next, rootNext.next);
			rootNext = rootNext.next;
			node = node.next;
		}
		// System.out.println(map);
		node = head;
		rootNext = root;
		while (node != null) {
			if (node.random != null) {
				rootNext.random = map.get(node);
			}
			rootNext = rootNext.next;
			node = node.next;
		}
		// RandomListNode.printList(root);
		return root;
	}

}
