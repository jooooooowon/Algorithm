package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 치즈도둑7733 {
	static int n;
	static int[][] arr;
	static int[] dirX = { 1, -1, 0, 0 };
	static int[] dirY = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int testCase = 1; testCase <= test; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 1;
			for (int i = 0; i <= 100; i++) {
				boolean[][] chkArr = makeChkArr(i);
				int tempCnt = 0;
				for (int y = 0; y < n; y++) {
					for (int x = 0; x < n; x++) {
						if (!chkArr[y][x]) {
							tempCnt++;
							dfs(y, x, chkArr);
						}
					}
				}
				max = Math.max(max, tempCnt);
			}
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
		
	}

	private static void dfs(int y, int x, boolean[][] chkArr) {
	
		for (int i = 0; i < 4; i++) {
			int nextY = y + dirY[i];
			int nextX = x + dirX[i];
			if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !chkArr[nextY][nextX]) {
				chkArr[nextY][nextX] = true;
				dfs(nextY, nextX, chkArr);
			}
		}

	}

	private static boolean[][] makeChkArr(int num) {
		boolean[][] result = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= num) {
					result[i][j] = true;
				}
			}
		}
		
		return result;
	}
}
