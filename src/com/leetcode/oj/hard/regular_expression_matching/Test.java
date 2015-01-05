package com.leetcode.oj.hard.regular_expression_matching;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	
	public void testSave() {
		assertEquals(new Solution().isMatch("aa", "a"), false);
		assertEquals(new Solution().isMatch("aa", "aa"), true);
		assertEquals(new Solution().isMatch("aaa", "aa"), false);
		assertEquals(new Solution().isMatch("aa", "a*"), true);
		assertEquals(new Solution().isMatch("aa", ".*"), true);
		assertEquals(new Solution().isMatch("ab", ".*"), true);
		assertEquals(new Solution().isMatch("aab", "c*a*b"), true);
		assertEquals(new Solution().isMatch("ababababa", "a*."), false);
		assertEquals(new Solution().isMatch("aaa", "aaaa"), false);
		assertEquals(new Solution().isMatch("bb", ".bab"), false);
		assertEquals(new Solution().isMatch("ab", ".*c"), false);
		assertEquals(new Solution().isMatch("ab", ".*.."), true);
	}
	
	
	
}
