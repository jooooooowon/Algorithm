package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.util.Scanner;

public class Jwon_20230804_B_NQueen {
	
	static int count = 0;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		find(0,arr);
		System.out.println(count);
	}

	private static void find(int x, int[] arr) {
		if(x == n) {
			count++;
			return ;
		}
		// i�� y��� ������ ����.
		// ���� x ��ǥ������ y�� 0���� ������ Ȯ���Ѵ�.
		for(int i = 0; i < n ; i++) {
			// tf�� ���� ���ڰ� ���� �����ǿ� ������ �� Ȯ�ο�.
			boolean tf = true;
			for(int j = 0 ; j < x ; j++) {
				// ���� x��ǥ������ ���� ��ġ�� ���� ���� ��ǥ�� ���� ���� �� �ִ� �� Ȯ��
				// x�� ������ �ٸ��� ������ y�� ������ false
				if(i == arr[j]) {
					tf = false;
					break;
				}
				// ���Ⱑ 1�̸� false
				if(Math.abs(i - arr[j])  == Math.abs(x - j)) {
					tf = false;
					break;
				}
			}
			// false��� �� ���� ������ �������� �Ѿ�� �ƴ϶�� �ٸ� ������ Ȯ��.
			if(tf) {
				arr[x] = i;
				find(x+1,arr);
			}
		}
		
	}
}
