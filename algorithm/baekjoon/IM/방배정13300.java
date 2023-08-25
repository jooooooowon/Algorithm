package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 방배정13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[7][2];
		for(int i = 0 ; i < n ; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			arr[grade][gender]++;
		}
		int sum = 0;
		for(int i = 1 ; i < 7 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				sum += arr[i][j] / k;
				if(arr[i][j] % k != 0) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}
