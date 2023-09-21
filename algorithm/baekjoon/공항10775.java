package Algorithm.algorithm.baekjoon;

import java.util.Scanner;

public class 공항10775 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gCount = sc.nextInt();
		int p = sc.nextInt();
		arr = new int[gCount + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		int count = 0;
		for (int i = 0; i < p; i++) {
			int g = sc.nextInt();
			int temp = find(g);
			if (temp == 0) {
				break;
			} else {
				unionMake(temp, temp - 1);
				count++;
			}
		}
		System.out.println(count);
	}

	private static void unionMake(int num1, int num2) {
		int from = find(num1);
		int to = find(num2);
		arr[from] = to;
	}

	private static int find(int num) {
		if (arr[num] == num) {
			return num;
		}
		return arr[num] = find(arr[num]);
	}
}
