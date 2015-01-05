package com.leetcode.oj.medium.search_in_rotated_sorted_array2;

import junit.framework.TestCase;

public class Test extends TestCase {
	public void testSolution() {
		Solution s = new Solution();
		assertEquals(s.search(new int[] { 3 }, 3), true);
		assertEquals(s.search(new int[] {}, 3), false);
		assertEquals(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2), true);
		assertEquals(s.search(new int[] { 4, 5, 1, 2, 3 }, 2), true);
		assertEquals(s.search(new int[] { 1, 3, 5 }, 0), false);
		assertEquals(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3), false);
		assertEquals(s.search(new int[] { 3, 1, 2 }, 0), false);
		assertEquals(s.search(new int[] { 3, 5, 1 }, 0), false);
		assertEquals(s.search(new int[] { 1, 3 }, 3), true);
		assertEquals(s.search(new int[] { 3, 5, 1 }, 3), true);
		assertEquals(s.search(new int[] { 3, 1 }, 0), false);
		assertEquals(s.search(new int[] { 5, 1, 3 }, 5), true);
		assertEquals(s.search(new int[] {1,1 }, 0), false);
	}
}
