package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve2105디저트카페 {
	static int[][] arr;
	static int[] dirY = { 1, 1 };
	static int[] dirX = { 1, -1 };
	static boolean[][] visited;
	static boolean[] chk;
	static int result;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					chk = new boolean[101];
					find(0, 0, i, j, 0, 0);
				}
			}
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void find(int left, int right, int y, int x, int dir, int count) {
		if (dir == 2) {
			boolean[] temp = chk.clone();
			
			while(right-- > 0) {
				x--;
				y--;
				if(y < 0 || x < 0 || temp[arr[y][x]]) {
					return ;
				}
				temp[arr[y][x]] = true;
				count++;
			}
			while(left -- > 0) {
				x++;
				y--;
				if(y < 0 || x >= n || temp[arr[y][x]]) {
					return ;
				}
				temp[arr[y][x]] = true;
				count++;
			}
			result = Math.max(result, count);
			return;
		}
		if (dir == 0) {
			int tempY = y + dirY[dir];
			int tempX = x + dirX[dir];
			if (tempY >= 0 && tempY < n && tempX >= 0 && tempX < n && !chk[arr[tempY][tempX]]) {
				chk[arr[tempY][tempX]] = true;
				find(left, right + 1, tempY, tempX, dir, count + 1);
				chk[arr[tempY][tempX]] = false;
			}
			tempY = y + dirY[dir + 1];
			tempX = x + dirX[dir + 1];
			if (count > 0 && tempY >= 0 && tempY < n && tempX >= 0 && tempX < n && !chk[arr[tempY][tempX]]) {
				chk[arr[tempY][tempX]] = true;
				find(left + 1, right, tempY, tempX, dir + 1, count + 1);
				chk[arr[tempY][tempX]] = false;
			}
		} else if (dir == 1) {
			int tempY = y + dirY[dir];
			int tempX = x + dirX[dir];
			if (tempY >= 0 && tempY < n && tempX >= 0 && tempX < n && !chk[arr[tempY][tempX]]) {
				chk[arr[tempY][tempX]] = true;
				find(left + 1, right, tempY, tempX, dir, count + 1);
				chk[arr[tempY][tempX]] = false;
			}
			find(left, right, y, x, dir + 1, count);
		}
	}

}
