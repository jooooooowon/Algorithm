package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemLadder1_1210 {
	static int[][] arr;
	static boolean[][] chk;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			int test = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			chk = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1)
						chk[i][j] = true;
				}
			}
			int start = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2)
					start = i;
			}

			int result = find(99, start);
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int find(int y, int x) {
		if (y == 0) {
			return x;
		}
		int[] dirX = { 1, -1, 0 };
		int[] dirY = { 0, 0, -1 };
		for (int i = 0; i < 3; i++) {
			int tempX = x + dirX[i];
			int tempY = y + dirY[i];
			if (tempX >= 0 && tempX < 100 && tempY >= 0 && chk[tempY][tempX]) {
				chk[tempY][tempX] = false;
				return find(tempY, tempX);
			}
		}
		return x;

	}
}
