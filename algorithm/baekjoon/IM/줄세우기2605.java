package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 줄세우기2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i = 0 ; i < len ; i++) {
			int n = sc.nextInt();
			arr[i] = i+1;
			for(int j = 0 ; j < n ; j++) {
				int temp = arr[i-j];
				arr[i-j] = arr[i-j-1];
				arr[i-j-1] = temp;
			}
		}
		for(int temp : arr) {
			System.out.print(temp + " ");
		}
	}
}
