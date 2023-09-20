package Algorithm.algorithm.baekjoon.A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기14499 {
	// 맨 위 1,1 (중심)
	// 중심 기준 위 0,1
	// 중심 기준 좌 1,0
	// 중심 기준 우 0,1
	// 중심 기준 하 1,2
	// 중심 기준 반대 1,3
	static int[][] dice = new int[4][3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			// 1 2 3 4
			// 동 서 북 남
			int direction = Integer.parseInt(st.nextToken());
			rollDice(direction);
		}
	}

	private static void rollDice(int direction) {
		// TODO Auto-generated method stub
		if (direction == 1) {
			
		} else if (direction == 2) {

		} else if (direction == 3) {

		} else if (direction == 4) {

		}
	}
}
