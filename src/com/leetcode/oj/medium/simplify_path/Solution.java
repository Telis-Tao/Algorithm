package com.leetcode.oj.medium.simplify_path;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
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
		// s.simplifyPath("/a/./b/../../c/");
		// s.simplifyPath("/home/");
		// s.simplifyPath("/home");
		// s.simplifyPath("/home/../../..");
		// s.simplifyPath("//");
		// s.simplifyPath("/");
		// s.simplifyPath("/.");
		// s.simplifyPath("/...");
		// s.simplifyPath("////");
		// s.simplifyPath("/abc/...");
		s.simplifyPath("///eHx/..");
	}

	public String simplifyPath(String path) {
		int index = 0;
		Stack<String> stack = new Stack<>();
		String temp = new String();
		while (++index < path.length()) {
			char c = path.charAt(index);
			if (c == '/') {
				if (temp.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else if (temp.equals(".")) {

				} else {
					if (!temp.equals(""))
						stack.push(temp);
				}
				temp = "";
			} else {
				temp += c;
			}
		}
		if (temp.equals("..")) {
			if (!stack.isEmpty())
				stack.pop();
		} else if (!(temp.equals(".") || temp.equals(""))) {
			stack.push(temp);
		}
		String result = "/";
		if (stack.isEmpty()) {
			return result;
		}
		for (int i = 0; i < stack.size(); i++) {
			result += stack.get(i) + "/";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}
}
