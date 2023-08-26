package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 개미10158 {
	static int w;
	static int h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int t = sc.nextInt();
		t %= w*h;
		
		find(x, y, t, 0, 1, 1);
	}

	private static void find(int x, int y, int t, int count, int dirX, int dirY) {
		if (count == t) {
			System.out.print(x + " " + y);
			System.exit(0);
		}
		int nextX = x + dirX;
		int nextY = y + dirY;
		if (nextX == w && nextY == h) {
			dirX = -1;
			dirY = -1;
		} else if (nextX == 0 && nextY == h) {
			dirX = 1;
			dirY = -1;
		} else if (nextX == 0 && nextY == 0) {
			dirX = 1;
			dirY = 1;
		} else if (nextX == w && nextY == 0) {
			dirX = -1;
			dirY = 1;
		} else if (nextX == w) {
			dirX = -1;
		} else if (nextX == 0) {
			dirX = 1;
		} else if (nextY == h) {
			dirY = -1;
		} else if (nextY == 0) {
			dirY = 1;
		}
		find(nextX,nextY,t,count+1,dirX,dirY);
	}

}
