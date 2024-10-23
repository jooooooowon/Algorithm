package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.util.Scanner;

public class 이상한술집_13702 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		long end = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			end = Math.max(end, arr[i]);
		}
		long start = 1;
		long answer = 0;
		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0;
			for (int i = 0; i < n; i++) {
				count += (long) arr[i] / mid;
			}
			if (count >= k) {
				answer = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
