package Algorithm.sasfy_algirithm_part.d4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWProblemSolve1226미로1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			int test = sc.nextInt();
			int n = 16;
			int startR = 0;
			int startC = 0;
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if (arr[i][j] == 2) {
						startR = i;
						startC = j;
					}
				}
			}
			sb.append("#").append(test).append(" ");
			if (dfs(startR, startC, arr)) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static int[] dirC = { 1, -1, 0, 0 };
	static int[] dirR = { 0, 0, 1, -1 };

	private static boolean dfs(int startR, int startC, int[][] arr) {
		for (int i = 0; i < 4; i++) {
			int tempC = startC + dirC[i];
			int tempR = startR + dirR[i];
			if (arr[tempR][tempC] == 0 || arr[tempR][tempC] == 3) {
				if (arr[tempR][tempC] == 3) {
					return true;
				}
				arr[tempR][tempC] = 1;
				if (dfs(tempR, tempC, arr)) {
					return true;
				}
				arr[tempR][tempC] = 0;
			}
		}
		return false;
	}
}
