package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 색종이2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int paperCnt = sc.nextInt();
		boolean[][] arr = new boolean[101][101];
		for(int paper = 0 ; paper < paperCnt ; paper++) {
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			for(int y = startY ; y < startY + 10 ; y++) {
				for(int x = startX ; x < startX + 10 ; x++) {
					arr[y][x] = true;
				}
			}
		}
		int area = 0;
		for(int y = 1 ; y < 101 ; y++) {
			for(int x = 1 ; x < 101 ; x++) {
				if(arr[y][x]) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}
