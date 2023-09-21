package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class SWProblemSolve보급로1249 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= test; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			Queue<Node> queue = new LinkedList<>();
			queue.offer(new Node(0, 0));
			boolean[][] chk = new boolean[n][n];
			chk[0][0] = true;
			int[][] count = new int[n][n];
			int[] dirC = { 1, -1, 0, 0 };
			int[] dirR = { 0, 0, 1, -1 };

			while (!queue.isEmpty()) {
				Node node = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nextC = node.c + dirC[i];
					int nextR = node.r + dirR[i];
					if (nextC >= 0 && nextC < n && nextR >= 0 && nextR < n) {
						int tempCount = arr[nextR][nextC] + count[node.r][node.c];
						if (!chk[nextR][nextC]) {
							chk[nextR][nextC] = true;
							count[nextR][nextC] = tempCount;
							queue.offer(new Node(nextR, nextC));
						} else if (count[nextR][nextC] > tempCount) {
							count[nextR][nextC] = tempCount;
							queue.offer(new Node(nextR, nextC));
						}
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(count[n - 1][n - 1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
