package Algorithm.algorithm.baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Jwon_20230922_B_3190_뱀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] apples = new boolean[n][n];
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			apples[y][x] = true;
		}
		int l = sc.nextInt();
		// 우 하 좌 상,
		// 0 1 2 3
		int[] dirX = { 1, 0, -1, 0 };
		int[] dirY = { 0, 1, 0, -1 };
		Deque<Node> deque = new ArrayDeque<>();
		deque.addLast(new Node(0, 1, 0));
		int time = 1;
		for (int i = 0; i < l; i++) {
			int length = sc.nextInt();
			char dir = sc.next().charAt(0);
			Node temp = deque.peekLast();
			int tempDir = temp.direction;
			tempDir += 4;
			if (dir == 'L') {
				tempDir -= 1;
			} else {
				tempDir += 1;
			}
			tempDir %= 4;
			for (int j = 0; j < length; j++) {
				System.out.println("snake's len : " + deque.size());
				time++;
				Node node = deque.peekLast();
				System.out.println(node);
				int tempX = dirX[tempDir] + node.x;
				int tempY = dirY[tempDir] + node.y;
				Node chkNode = new Node(tempY, tempX, tempDir);
				if (tempX < 0 || tempX >= n || tempY < 0 || tempY >= n || deque.contains(chkNode)) {
					System.out.println("chkNode : " + chkNode);
					System.out.println(time);
					return;
				}
				if (apples[tempY][tempX]) {
					apples[tempY][tempX] = false;
				} else {
					deque.pollFirst();
				}
				deque.addLast(chkNode);
			}
		}
	}

	static class Node {
		int y;
		int x;
		int direction;

		public Node(int y, int x, int direction) {
			super();
			this.y = y;
			this.x = x;
			this.direction = direction;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				Node temp = (Node) obj;
				if (temp.y == this.y && temp.x == this.x) {
					return true;
				}
			}
			return false;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", direction=" + direction + "]";
		}

	}
}
