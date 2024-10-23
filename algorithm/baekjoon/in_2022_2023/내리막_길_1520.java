package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막_길_1520 {
	static int[][] dp;
	static int[][] arr;
	static boolean[][] visited;
	static int m;
	static int n;

	// 우선 500,500 이므로 쌩 dfs나 bfs를 이용하면 시간초과가 난다.
	// 따라서 dp를 이용하여 계산된 값들을 기억하며 이용한다.
	// dp[i][j]는 i,j까지의 모든 경우의 수를 저장하고 있다.
	// 현재의 위치는 현재보다 높은 위치의 해당하는 경우의 수를 모두 더해주면 된다.
	// 이 때 생각해야할 것은 어느 위치에 왔다면 그 위치는 다시 탐색을 하지 않고 저장되어 있는 값을 내어준다고 생각하면된다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		visited = new boolean[m][n];
		dp = new int[m][n];
		dp[0][0] = 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(m - 1, n - 1);
		System.out.println(dp[m - 1][n - 1]);
	}

	static int[] dirY = { 1, -1, 0, 0 };
	static int[] dirX = { 0, 0, 1, -1 };

	private static int dfs(int i, int j) {
		// 만약 방문을 완료한 위치라면 이미 모든 경우의 수를 구한 상태이므로 경우의 수를 리턴한다.
		if (visited[i][j]) {
			return dp[i][j];
		}
		// 현재 방문했으니까 true
		visited[i][j] = true;
		for (int idx = 0; idx < 4; idx++) {
			int nextY = i + dirY[idx];
			int nextX = j + dirX[idx];
			if (nextY >= 0 && nextY < m && nextX >= 0 && nextX < n && arr[i][j] < arr[nextY][nextX]) {
				// 높은 위치에서 모두 내려올 수 있기 때문에
				// 자신보다 높은 위치의 경우의 수를 모두 더해준다.
				dp[i][j] += dfs(nextY, nextX);
			}
		}
		return dp[i][j];
	}
}
