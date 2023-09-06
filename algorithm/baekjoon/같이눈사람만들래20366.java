package Algorithm.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 같이눈사람만들래20366 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int oldStart = 0;
		int oldEnd = 3;
		int youngStart = 1;
		int youngEnd = 2;
		int min = Math.abs((arr[oldEnd] - arr[oldStart]) - (arr[youngEnd] - arr[youngStart]));
		while ((oldStart < n && oldEnd < n && youngStart < n && youngEnd < n) && min > 0) {
			int oldSum = arr[oldEnd] - arr[oldStart];
			int youngSum = arr[youngEnd] - arr[youngStart];
			min = Math.min(min, Math.abs(oldSum - youngSum));
			if (oldSum > youngSum) {
				youngStart++;
			} else {
				oldStart++;
			}
			if (oldStart == youngStart) {
				youngStart++;
			}
			if (youngStart == youngEnd) {
				youngEnd++;
			}
			if (oldEnd == youngEnd) {
				oldEnd++;
			}
		}
		System.out.println(min);
	}
}
