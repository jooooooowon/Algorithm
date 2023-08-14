package Algorithm.sasfy_algirithm_part.d2;

import java.util.Scanner;

public class SnailNum1954 {

	static int[] dirX = {1,0,-1,0};
	static int[] dirY = {0,-1,0,1};
	static int n;
	static int[][] arr ;
	static boolean[][] chk ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test ; testCase++) {
			n = sc.nextInt();
			arr = new int[n+2][n+2];
			chk = new boolean[n+2][n+2];
			for(int i = 1; i < n + 1 ; i++) {
				for(int j = 1; j < n + 1 ; j++) {
					chk[i][j] = true;
				}
			}
			snail(1,0,1,1);
			sb.append("#").append(testCase).append("\n");
			for(int i = 1 ; i < n + 1 ; i++) {
				for(int j = 1; j < n + 1 ; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void snail(int count, int dir, int y, int x) {
		arr[y][x] = count;
		if(count == Math.pow(n, 2)) {
			return ;
		}
		chk[y][x] = false;
		
		int tempY = dirY[dir] + y;
		int tempX = dirX[dir] + x;
		if(!chk[tempY][tempX]) {
			dir++;
			if(dir >= 4)
				dir = 0;
			snail(count,dir,y,x);
			return ;
		}
		
		snail(count+1,dir,tempY,tempX);
	}
}
