package Algorithm.sasfy_algirithm_part.d3;

import java.util.Arrays;
import java.util.Scanner;

public class 최장경로2814 {
	static int max;
	static int n;
	static boolean[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			n = sc.nextInt();
			int m = sc.nextInt();

			arr = new boolean[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = true;
				arr[y][x] = true;
			}

			max = 1;
			for (int i = 1; i <= n; i++) {
				boolean[] tempArr = new boolean[n + 1];
				Arrays.fill(tempArr, true);
				dfs(i, 1, tempArr);
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int i, int count, boolean[] tempArr) {
		max = Math.max(max, count);
		tempArr[i] = false;
		for (int index = 1; index <= n; index++) {
			if (arr[i][index] && tempArr[index]) {
				dfs(index, count + 1, tempArr);
			}
		}
		tempArr[i] = true;
	}

}
