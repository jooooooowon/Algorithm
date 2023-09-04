package Algorithm.algorithm.baekjoon.A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] arr = new char[row][col];
		Marble[] marbles = new Marble[2]; // 0 : red, 1 : blue
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < col; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'R') {
					marbles[0] = new Marble(i, j, 0);
				} else if (arr[i][j] == 'B') {
					marbles[1] = new Marble(i, j, 0);
				}
			}
		}
		// 상 하 좌 우
		int[] dirX = { 0, 0, -1, 1 };
		int[] dirY = { 1, -1, 0, 0 };
		Queue<Marble[]> queue = new LinkedList<>();
		while (queue.isEmpty()) {
			Marble[] temp = queue.poll();
			Marble red = temp[0];
			Marble blue = temp[1];
			boolean tf = false;
			for(int i = 1 ; i < col ; i++) {
				if(arr[red.y][i] == '#') {
					break;
				}
			}
		}
	}

	static class Marble {
		int y;
		int x;
		int count;

		public Marble(int y, int x, int count) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}
