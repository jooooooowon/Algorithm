package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬디펜스17135 {
	static int n;
	static int m;
	static int d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		for (int bit = 0; bit < (1 << m); bit++) {
			int[][] tempArr = new int[n][m];
			for (int i = 0; i < n; i++) {
				tempArr[i] = arr[i].clone();
			}
			if (Integer.bitCount(bit) == 3) {
				int[] archer = new int[3];
				int index = 0;
				for (int i = 0; i < m; i++) {
					if ((bit & (1 << i)) > 0) {
						archer[index++] = i;
					}
				}
				max = Math.max(max, playGame(archer, tempArr));
			}
		}
		System.out.println(max);
	}

	static HashSet<Node> set;

	private static int playGame(int[] archer, int[][] tempArr) {
		int level = n;
		int count = 0;
		set = new HashSet<>();
		while (level > 0) {
			for (int arc = 0; arc < 3; arc++) {
				kill(level, archer[arc], tempArr);
			}
			if (set.size() > 0) {
				count = set.size();
				for (Node node : set) {
					tempArr[node.y][node.x] = 0;
				}
			}
			level--;
		}
		return count;
	}

	private static void kill(int level, int arc, int[][] tempArr) {
		if (tempArr[level - 1][arc] == 1) {
			set.add(new Node(level - 1, arc));
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(level - 1, arc, 1));

		int[] dirX = { -1, 0, 1 };
		int[] dirY = { 0, -1, 0 };
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.distance + 1 <= d) {
				for (int i = 0; i < 3; i++) {
					int tempX = node.x + dirX[i];
					int tempY = node.y + dirY[i];
					if (tempX >= 0 && tempX < m && tempY >= 0) {
						if (tempArr[tempY][tempX] == 1) {
							set.add(new Node(tempY, tempX));
							return;
						} else {
							queue.offer(new Node(tempY, tempX, node.distance + 1));
						}
					}
				}
			}
		}
		return;
	}

	static class Node {
		int y;
		int x;
		int distance;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public Node(int y, int x, int distance) {
			super();
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				Node node = (Node) obj;
				if (node.y == this.y && node.x == this.x) {
					return true;
				}
			}
			return false;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", distance=" + distance + "]";
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.y + this.x + this.distance;
		}

	}
}
