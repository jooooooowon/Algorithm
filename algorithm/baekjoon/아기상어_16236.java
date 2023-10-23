package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		StringTokenizer st;
		int startY = 0;
		int startX = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					startY = i;
					startX = j;
					arr[i][j] = 0;
				}
			}
		}
		boolean[][] visited = new boolean[n][n];
		Queue<Shark> queue = new LinkedList<>();
		queue.offer(new Shark(startY, startX, 2, 0, 0));
		visited[startY][startX] = true;
		int[] dirY = { -1, 0, 0, 1 };
		int[] dirX = { 0, -1, 1, 0 };
		int answer = 0;
		while (!queue.isEmpty()) {
			Shark now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dirY[i];
				int nextX = now.x + dirX[i];
				if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !visited[nextY][nextX]
						&& now.size >= arr[nextY][nextX]) {
					visited[nextY][nextX] = true;
					if (arr[nextY][nextX] > 0 && arr[nextY][nextX] < now.size) {
						System.out.println("y : " + nextY);
						System.out.println("x : " + nextX);
						System.out.println("time : " + now.time + 1);
						System.out.println(now.toString());
						answer = now.time + 1;
						if(now.count + 1 == now.size) {
							queue = new LinkedList<>();
							visited = new boolean[n][n];
							visited[nextY][nextX] = true;
							queue.offer(new Shark(nextY, nextX, now.size + 1, 0, now.time + 1));
						}else {
							queue.offer(new Shark(nextY, nextX, now.size, now.count + 1, now.time + 1));
						}
					}else {
						queue.offer(new Shark(nextY, nextX, now.size, now.count, now.time + 1));
					}
				}
			}
		}
		System.out.println(answer);
	}

	static class Shark {
		int y;
		int x;
		int size;
		int count;
		int time;

		public Shark(int y, int x, int size, int count, int time) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.count = count;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Shark [y=" + y + ", x=" + x + ", size=" + size + ", count=" + count + "]";
		}

	}
}
