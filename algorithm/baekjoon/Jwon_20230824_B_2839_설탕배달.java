package Algorithm.algorithm.baekjoon;

import java.util.Scanner;

public class Jwon_20230824_B_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[5001];
		arr[3] = 1;
		arr[5] = 1;

		for (int i = 0; i <= n; i++) {
			if (arr[i] != 0) {
				if (i + 3 < 5001) {
					if (arr[i + 3] != 0) {
						arr[i + 3] = Math.min(arr[i + 3], arr[i] + 1);
					} else {
						arr[i + 3] = arr[i] + 1;
					}
				}
				if (i + 5 < 5001) {
					if (arr[i + 5] != 0) {
						arr[i + 5] = Math.min(arr[i + 5], arr[i] + 1);
					} else {
						arr[i + 5] = arr[i] + 1;
					}
				}
			}
		}
		if (arr[n] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(arr[n]);
		}
	}
}
