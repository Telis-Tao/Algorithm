package com.leetcode.oj.medium.gray_code;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0 01 - 1 11 - 3 10 - 2 Note: For a given n, a gray code sequence is not
 * uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
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
		System.out.println(s.grayCode(4));
	}

	//
	// * public List<Integer> grayCode(int n) { List<Integer> list = new
	// * ArrayList<Integer>(); list.add(0); if (n == 0) { return list; }
	// String[]
	// * ref = new String[n]; for (int i = 0; i < ref.length; i++) { ref[i] =
	// "";
	// * for (int j = 0; j < i; j++) { ref[i] += "0"; } } Set<String> set = new
	// * HashSet<String>(); for (int i = 0; i < Math.pow(2, n); i++) { String
	// str
	// * = Integer.toBinaryString(i); if (str.length() < n) { str = ref[n -
	// * str.length()] + str; } set.add(str); } set.remove(ref[ref.length - 1] +
	// * "0"); while (!set.isEmpty()) { String temp =
	// * Integer.toBinaryString(list.get(list.size() - 1)); if (temp.length() <
	// n)
	// * { temp = ref[n - temp.length()] + temp; } for (int i = n - 1; i >= 0;
	// * i--) { String str = change(temp, i); if (set.contains(str)) {
	// * list.add(Integer.parseInt(str, 2)); set.remove(str); break; } } }
	// return
	// * list; }
	// *
	// * private String change(String temp, int i) { // TODO Auto-generated
	// method
	// * stub String c; if (temp.charAt(i) == '0') { c = "1"; } else { c = "0";
	// }
	// * return temp.subSequence(0, i) + c + temp.subSequence(i + 1,
	// * temp.length()); }
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int i = 0; i < n; i++) {
			int inc = 1 << i;
			for (int j = list.get(list.size() - 1); j >= 0; j--) {
				list.add(list.get(j) + inc);
			}
		}
		return list;
	}

}
