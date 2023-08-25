package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 색종이10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[1001][1001];
		for (int paper = 1; paper <= n; paper++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int i = y; i < y + h; i++) {
				for (int j = x; j < x + w; j++) {
					arr[i][j] = paper;
				}
			}
		}
		for(int paper = 1 ; paper <= n ; paper++) {
			int area = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(arr[i][j] == paper) {
						area++;
					}
				}
			}
			System.out.println(area);
		}
	}
}
