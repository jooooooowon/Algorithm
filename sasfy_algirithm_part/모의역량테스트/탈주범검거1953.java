package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거1953 {
	static int[][] arr;
	static boolean[][] chk;
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			chk = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Node> queue = new LinkedList<>();
			queue.offer(new Node(r, c, 1));
			chk[r][c] = true;
			// 상 하 좌 우
			int[] dirC = { 0, 0, -1, 1 };
			int[] dirR = { -1, 1, 0, 0 };
			int tempCount = 0;

//			System.out.println("testCase : " + testCase);
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				
//				chk[node.r][node.c] = true;
//				System.out.println(node);
				tempCount++;
				if (node.time == l) {
//					System.out.println("lasttime : " + node.time);
					continue;
				}
				int direction = arr[node.r][node.c];
//				System.out.println("direction : " + direction);
				switch (direction) {
				case 1:

					// 상
					int tempC = node.c + dirC[0];
					int tempR = node.r + dirR[0];
					if (upChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 하
					tempC = node.c + dirC[1];
					tempR = node.r + dirR[1];
					if (downChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 좌
					tempC = node.c + dirC[2];
					tempR = node.r + dirR[2];
					if (leftChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 우
					tempC = node.c + dirC[3];
					tempR = node.r + dirR[3];
					if (rightChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					break;
				case 2:
					// 상
					tempC = node.c + dirC[0];
					tempR = node.r + dirR[0];
					if (upChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 하
					tempC = node.c + dirC[1];
					tempR = node.r + dirR[1];
					if (downChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					break;
				case 3:
					// 좌
					tempC = node.c + dirC[2];
					tempR = node.r + dirR[2];
					if (leftChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 우
					tempC = node.c + dirC[3];
					tempR = node.r + dirR[3];
					if (rightChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					break;
				case 4:
					// 상
					tempC = node.c + dirC[0];
					tempR = node.r + dirR[0];
					if (upChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 우
					tempC = node.c + dirC[3];
					tempR = node.r + dirR[3];
					if (rightChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}

					break;
				case 5:
					// 하
					tempC = node.c + dirC[1];
					tempR = node.r + dirR[1];
					if (downChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 우
					tempC = node.c + dirC[3];
					tempR = node.r + dirR[3];
					if (rightChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					break;
				case 6:
					// 하
					tempC = node.c + dirC[1];
					tempR = node.r + dirR[1];
					if (downChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 좌
					tempC = node.c + dirC[2];
					tempR = node.r + dirR[2];
					if (leftChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					break;
				case 7:
					// 상
					tempC = node.c + dirC[0];
					tempR = node.r + dirR[0];
					if (upChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					// 좌
					tempC = node.c + dirC[2];
					tempR = node.r + dirR[2];
					if (leftChk(tempC, tempR)) {
						queue.offer(new Node(tempR, tempC, node.time + 1));
					}
					break;
				}
			}
			sb.append("#").append(testCase).append(" ").append(tempCount).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 1 +
	// 2 |
	// 3 -
	// 4 └
	// 5 ┌
	// 6 ┐
	// 7 ┘
	
	private static boolean upChk(int tempC, int tempR) {
		if (tempC >= 0 && tempC < m && tempR >= 0 && tempR < n && !chk[tempR][tempC]
				&& (arr[tempR][tempC] == 1 || arr[tempR][tempC] == 2 || arr[tempR][tempC] == 5
						|| arr[tempR][tempC] == 6)) {
			chk[tempR][tempC] = true;
//			System.out.println("up can");
			return true;
		}
		return false;
	}

	private static boolean downChk(int tempC, int tempR) {
		if (tempC >= 0 && tempC < m && tempR >= 0 && tempR < n && !chk[tempR][tempC]
				&& (arr[tempR][tempC] == 1 || arr[tempR][tempC] == 2 || arr[tempR][tempC] == 4
						|| arr[tempR][tempC] == 7)) {
			chk[tempR][tempC] = true;

//			System.out.println("down can");
			return true;
		}
		return false;
	}

	private static boolean rightChk(int tempC, int tempR) {
		if (tempC >= 0 && tempC < m && tempR >= 0 && tempR < n && !chk[tempR][tempC]
				&& (arr[tempR][tempC] == 1 || arr[tempR][tempC] == 3 || arr[tempR][tempC] == 6
						|| arr[tempR][tempC] == 7)) {
			chk[tempR][tempC] = true;

//			System.out.println("right can");
			return true;
		}
		return false;
	}

	private static boolean leftChk(int tempC, int tempR) {
		if (tempC >= 0 && tempC < m && tempR >= 0 && tempR < n && !chk[tempR][tempC]
				&& (arr[tempR][tempC] == 1 || arr[tempR][tempC] == 3 || arr[tempR][tempC] == 4
						|| arr[tempR][tempC] == 5)) {
			chk[tempR][tempC] = true;

//			System.out.println("left can");
			return true;
		}
		return false;
	}

	static class Node {
		int r;
		int c;
		int time;

		public Node(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

	}
}
