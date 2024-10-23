package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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
		// 시간 -> 위 > 아래 -> 왼쪽 > 오른쪽 순으로 우선순위를 정한다.
		PriorityQueue<Shark> pQueue = new PriorityQueue<>();
		// 시작점 넣어준다.
		// 매개변수 : y, x, 상어의 크기, 크기가 변한 후 먹은 물고기 수, 시간
		pQueue.offer(new Shark(startY, startX, 2, 0, 0));
		visited[startY][startX] = true;
		int[] dirY = { -1, 0, 0, 1 };
		int[] dirX = { 0, -1, 1, 0 };
		int answer = 0;
		while (!pQueue.isEmpty()) {
			Shark now = pQueue.poll();
			// 만약 현재 있는 곳이 먹을 수 있는 고기가 있다면
			if (arr[now.y][now.x] > 0 && arr[now.y][now.x] < now.size) {
				// 현재가 정답이 될 수 있으니 정답 갱신해준다.
				answer = now.time;
				// 왔던 길 모두 다시 갈 수 있으니 방문배열 다시 만들기
				visited = new boolean[n][n];
				// 물고기를 먹었으니 다시 물고기 먹기 (물고기를 먹은 시점부터 다시 확인한다.)
				pQueue = new PriorityQueue<>();
				// 현재 위치는 현재 방문한 상태이니 true
				visited[now.y][now.x] = true;
				// 물고기 잡솼으니 잡은 물고기 수 + 1
				now.count++;
				
				// 만약 물고기의 수가 현재 몸집의 크기와 같다면
				if(now.size == now.count) {
					// 물고기 몸집 키워주고, 먹은 물고기는 몸집이 커졌으니 다시 0
					now.size++;
					now.count = 0;
				}
				// 먹어서 없애기
				arr[now.y][now.x] = 0;
			}
			for (int i = 0; i < 4; i++) {
				int nextY = now.y + dirY[i];
				int nextX = now.x + dirX[i];
				if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n && !visited[nextY][nextX]
						&& now.size >= arr[nextY][nextX]) {
					visited[nextY][nextX] = true;
					pQueue.offer(new Shark(nextY, nextX, now.size, now.count, now.time + 1));
				}
			}
		}
		System.out.println(answer);
	}

	static class Shark implements Comparable<Shark> {
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
			return "Shark [y=" + y + ", x=" + x + ", size=" + size + ", count=" + count + ", time=" + time + "]";
		}

		@Override
		public int compareTo(Shark shark) {
			if (this.time == shark.time) {
				if (this.y == shark.y) {
					return this.x - shark.x;
				}
				return this.y - shark.y;
			}

			return this.time - shark.time;
		}
	}
}
