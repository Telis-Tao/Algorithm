package com.leetcode.oj.hard.wildcard_matching;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
	private static Solution s = new Solution();

	public void testMain() {
		assertEquals(false, s.isMatch("", "?"));
		assertEquals(false, s.isMatch("aa", "a"));
		assertEquals(true, s.isMatch("aa", "aa"));
		assertEquals(false, s.isMatch("aaa", "aa"));
		assertEquals(true, s.isMatch("aa", "*"));
		assertEquals(true, s.isMatch("ab", "?*"));
		assertEquals(false, s.isMatch("aab", "c*a*b"));
		assertEquals(false, s.isMatch("", "?"));
		assertEquals(false, s.isMatch("b", "?*?"));
		assertEquals(true, s.isMatch("b", "?*"));
		assertEquals(true, s.isMatch("b", "*?"));
		assertEquals(false, s.isMatch("b", "*?*?"));
		assertEquals(false, s.isMatch("b", "*?*?*"));
		assertEquals(true, s.isMatch("a", "*a*"));
		assertEquals(true, s.isMatch("hi", "*?"));
		assertEquals(false, s.isMatch("a", "aa"));
		assertEquals(false, s.isMatch("bad", "??"));
		assertEquals(true, s.isMatch("aa", "*a"));
		assertEquals(false, s.isMatch("ab", "*a"));
	}
}
