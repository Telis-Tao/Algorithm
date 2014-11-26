package com.leetcode.oj.easy.zigzag_conversion;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// System.out.println(s.convert("PAYPALISHIRING", 3));
		// System.out.println(s.convert("ABC", 1));
		System.out
				.println(s
						.convert(
								"twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd",
								4));
	}

	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		char[] c = s.toCharArray();
		StringBuffer[] strs = new StringBuffer[nRows];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = new StringBuffer();
		}
		int cLen = c.length;
		int currentChar = 0;
		int currentRow = 0;
		boolean isZig = true;
		while (currentChar < cLen) {
			if (currentRow >= nRows) {
				currentRow -= 2;
				isZig = false;
			} else if (currentRow < 0) {
				currentRow += 2;
				isZig = true;
			}
			if (isZig) {
				strs[currentRow++].append(c[currentChar++]);
			} else {
				strs[currentRow--].append(c[currentChar++]);
			}
		}
		// for (int i = 0; i < strs.length; i++) {
		// System.out.println(strs[i]);
		// }
		StringBuffer retStr = new StringBuffer();
		for (StringBuffer stringBuffer : strs) {
			retStr.append(stringBuffer);
		}
		return retStr.toString();
	}
}
