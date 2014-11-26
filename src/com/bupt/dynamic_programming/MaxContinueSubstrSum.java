package com.bupt.dynamic_programming;

/**
 * @author Telis
 * 
 */
public class MaxContinueSubstrSum {

	/**
	 * ����K������������{ N1, N2, ..., NK }�����������������пɱ�ʾΪ{ Ni, Ni+1, ..., Nj }������ 1 <= i
	 * <= j <= K�������������������������������Ԫ�غ�����һ���� �����������{ -2, 11, -4, 13, -5, -2
	 * }�����������������Ϊ{ 11, -4, 13 }������Ϊ20
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { -2, 11, -4, 13, -5, -2 };
		MaxContinueSubstrSum m = new MaxContinueSubstrSum();
		System.out.println(m.getSum(num));
	}

	public int getSum(int[] num) {
		int max = 0;
		int temp = num[0];
		for (int i = 1; i < num.length; i++) {
			if (temp < 0) {
				temp = num[i];
			} else {
				temp += num[i];
			}
			max = max > temp ? max : temp;
		}
		return max;
	}
}
