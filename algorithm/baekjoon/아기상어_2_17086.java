package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_2_17086 {
	static int[][] arr;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 1) {
					answer = Math.max(bfs(i, j), answer);
				}
			}
		}
		System.out.println(answer);
	}

	static int[] dirY = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dirX = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static int bfs(int y, int x) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		int[][] count = new int[n][m];
		count[y][x] = 1;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nextY = now.y + dirY[i];
				int nextX = now.x + dirX[i];
				if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && count[nextY][nextX] == 0) {
					if (arr[nextY][nextX] == 1) {
						return count[now.y][now.x];
					} else {
						count[nextY][nextX] = count[now.y][now.x] + 1;
						queue.offer(new Point(nextX, nextY));
					}
				}
			}
		}
		return 0;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
