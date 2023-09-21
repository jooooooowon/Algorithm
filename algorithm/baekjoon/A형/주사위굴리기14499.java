package Algorithm.algorithm.baekjoon.A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기14499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dirY = { 0, 0, 0, -1, 1 };
		int[] dirX = { 0, 1, -1, 0, 0 };

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			// 1 2 3 4
			// 동 서 북 남
			int direction = Integer.parseInt(st.nextToken());
			
			int tempY = y + dirY[direction];
			int tempX = x + dirX[direction];
			if(tempY >= 0 && tempY < n && tempX >= 0 && tempX < m) {
				rollDice(direction);
				y = tempY;
				x = tempX;
				if (arr[y][x] == 0) {
					arr[y][x] = dice[5];
				}else {
					dice[5] = arr[y][x];
					arr[y][x] = 0;
				}
				System.out.println(dice[0]);
			}
		}
	}

	//   1
	// 3 0 2
	//   4
	//   5

	// 1 2 3 4
	// 동 서 북 남
	static int[] dice = new int[6];

	private static void rollDice(int direction) {
		// TODO Auto-generated method stub
		if (direction == 1) {
			int temp = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = temp;
		} else if (direction == 2) {
			int temp = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[0];
			dice[0] = temp;
		} else if (direction == 3) {
			int temp = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[0];
			dice[0] = temp;
		} else if (direction == 4) {
			int temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = temp;
		}
	}
}
