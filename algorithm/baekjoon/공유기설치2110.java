package Algorithm.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기설치2110 {
	static int[] arr;
	static int max;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int c = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		max = 0;
		find(0, n - 1, 0, new boolean[n]);
		System.out.println(max);
	}

	private static void find(int start, int end, int count, boolean[] chk) {
		if (count == n) {
			
			return;
		}
		boolean[] tempChk = chk.clone();
		int tempMin = arr[end] - arr[start];
		int tempIndex = start;
		int startIndex = tempIndex;
		while (tempIndex < end) {
			int len = Math.abs((arr[tempIndex] - arr[start]) - (arr[end] - arr[tempIndex]));
			if (tempMin > len) {
				tempMin = len;
				startIndex = tempIndex;
			}
			tempIndex++;
		}
		tempChk[startIndex] = true;
		if (start < startIndex) {
			find(start, startIndex, count + 1,tempChk);
		}
		if (startIndex < end) {
			find(startIndex, end, count + 1,tempChk);
		}
	}
}
