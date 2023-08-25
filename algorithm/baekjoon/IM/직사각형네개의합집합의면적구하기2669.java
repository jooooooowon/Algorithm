package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 직사각형네개의합집합의면적구하기2669 {
	public static void main(String[] args) {
		boolean[][] arr = new boolean[100][100];
		Scanner sc = new Scanner(System.in);
		int area = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();
			int rightX = sc.nextInt();
			int rightY = sc.nextInt();
			for(int y = leftY ; y < rightY ; y++) {
				for(int x = leftX ; x < rightX ; x++) {
					arr[y][x] = true;
				}
			}
		}
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(arr[i][j]) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}
