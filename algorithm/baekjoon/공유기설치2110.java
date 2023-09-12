package Algorithm.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int max = 0;
		int start = 1;
		int end = arr[n - 1] - arr[0];
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 1;

			int installIndex = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i] - arr[installIndex] >= mid) {
					installIndex = i;
					count++;
				}
			}
			if (count < c) {
				end = mid - 1;
			} else {
				max = mid;
				start = mid + 1;
			}
		}
		System.out.println(max);
	}

}
