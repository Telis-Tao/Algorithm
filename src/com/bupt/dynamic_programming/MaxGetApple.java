package com.bupt.dynamic_programming;

/**
 * ƽ������N*M�����ӣ�ÿ�������з���һ��������ƻ����������Ͻǵĸ��ӿ�ʼ�� ÿһ��ֻ�������߻��������ߣ�ÿ���ߵ�һ�������ϾͰѸ������ƻ���ռ�������
 * ������ȥ����������ռ������ٸ�ƻ��
 * 
 * @author Telis
 * 
 */
public class MaxGetApple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxGetApple m = new MaxGetApple();
		int[][] apples = m.getApples(4, 5);
		System.out.println("apples:");
		m.iter(apples);
		System.out.println("results:");
		int[][] results = m.Solution(apples);
		m.iter(results);
	}

	public int[][] getApples(int lenth, int width) {
		int[][] apples = new int[lenth][width];
		for (int i = 0; i < apples.length; i++) {
			for (int j = 0; j < apples[i].length; j++) {
				apples[i][j] = (int) (Math.random() * 50);
			}
		}
		return apples;
	}

	public int[][] Solution(int[][] apples) {
		int[][] results = new int[apples.length][apples[0].length];
		results[0][0] = apples[0][0];
		// ��һ��
		for (int i = 1; i < apples[0].length; i++) {
			results[0][i] = results[0][i - 1] + apples[0][i];
		}
		// ��һ��
		for (int i = 1; i < apples.length; i++) {
			results[i][0] = results[i - 1][0] + apples[i][0];
		}
		for (int i = 1; i < apples.length; i++) {
			for (int j = 1; j < apples[i].length; j++) {
				results[i][j] = apples[i][j]
						+ Math.max(results[i - 1][j], results[i][j - 1]);
			}
		}
		return results;
	}

	public void iter(int[][] results) {
		for (int i = 0; i < results.length; i++) {
			for (int j = 0; j < results[i].length; j++) {
				System.out.print(results[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
