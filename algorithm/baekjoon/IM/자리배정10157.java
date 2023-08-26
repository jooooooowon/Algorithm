package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 자리배정10157 {
	static int[] dirY = { 1, 0, -1, 0 };
	static int[] dirX = { 0, 1, 0, -1 };
	static boolean[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		if(k > r * c || k < 1) {
			System.out.println(0);
			System.exit(0);
		}
		arr = new boolean[c + 2][r + 2];
		for (int i = 1; i < c + 1; i++) {
			for (int j = 1; j < r + 1; j++) {
				arr[i][j] = true;
			}
		}
		
		find(0,1,1,1,k);
	}
	
	private static void find(int dir, int x, int y, int count,int k) {
		if(count == k) {
			System.out.print(x + " " + y);
			return ;
		}
		arr[y][x] = false;
		int nextX = x + dirX[dir];
		int nextY = y + dirY[dir];
		if(arr[nextY][nextX]) {
			find(dir,nextX,nextY,count + 1, k);
		}else {
			dir += 1;
			dir %= 4;
			find(dir,x,y,count,k);
		}
	}
}
