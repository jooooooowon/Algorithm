package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jwon_20231102_B_로봇_조종하기 {
	static int[][] result;
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		result = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][m];
		visited[0][0] = true;
		result[0][0] = arr[0][0];

		dfs(n - 1, m - 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();

		}
		System.out.println(result[0][0]);
	}

	private static int dfs(int y, int x) {
		if (visited[y][x]) {
			return result[y][x];
		}
		visited[y][x] = true;
		int temp = -(100 * 1000 * 1000);
		for (int i = 0; i < 3; i++) {
			int nextY = y + dirY[i];
			int nextX = x + dirX[i];
			if (nextY >= 0 && nextX >= 0 && nextX < m) {
				temp = Math.max(temp, dfs(nextY, nextX));
			}
		}
		System.out.println("temp : " + temp);

		return result[y][x] = arr[y][x] + temp;
	}

	static int[] dirX = { -1, 0, 1 };
	static int[] dirY = { 0, -1, 0 };

	static class Node implements Comparable<Node> {
		int y;
		int x;
		int count;

		public Node(int y, int x, int count) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
		}

		@Override
		public int compareTo(Node node) {
			return result[node.y][node.x] - result[this.y][this.x];
		}

	}
}
