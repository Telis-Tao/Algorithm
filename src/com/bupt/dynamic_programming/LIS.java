package com.bupt.dynamic_programming;

/**
 * @author Telis
 * 
 */
public class LIS {

	/**
	 * ����K������������{ N1, N2, ..., NK }�����������������пɱ�ʾΪ{ Ni, Ni+1, ..., Nj }������ 1 <= i
	 * <= j <= K�������������������������������Ԫ�غ�����һ���� �����������{ -2, 11, -4, 13, -5, -2
	 * }�����������������Ϊ{ 11, -4, 13 }������Ϊ20
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-2, 11, -4, 13, -5, -2};
		LIS m = new LIS();
		System.out.println(m.getSum(num));
	}

	public int getSum(int[] num) {
		int[] maxNum = new int[num.length];
		maxNum[0] = 1;
		for (int i = 1; i < num.length; i++) {
			int max = maxNum[0];
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					max = max > maxNum[j] ? max : maxNum[j];
				}
			}
			maxNum[i] = max + 1;
		}
		return maxNum[num.length-1];
	}
}
