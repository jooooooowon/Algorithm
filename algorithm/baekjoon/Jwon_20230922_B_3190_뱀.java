package Algorithm.algorithm.baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Jwon_20230922_B_3190_뱀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] apples = new boolean[n + 1][n + 1];
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
		deque.addLast(new Node(1, 1));
		int time = 0;
		int direction = 0;
		for (int i = 0; i < l; i++) {
			int length = sc.nextInt();
			char dir = sc.next().charAt(0);
			for (int j = 0; j < length; j++) {
				System.out.println("snake's len : " + deque.size());
				time++;
				Node node = deque.peekLast();
				System.out.println(node);
				int tempX = dirX[direction] + node.x;
				int tempY = dirY[direction] + node.y;
				Node chkNode = new Node(tempY, tempX);
				if (tempX < 0 || tempX > n || tempY < 0 || tempY > n || deque.contains(chkNode)) {
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
			if (dir == 'L') {
				direction -= 1;
			} else {
				direction += 1;
			}
			direction += 4;
			direction %= 4;
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
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
			return "Node [y=" + y + ", x=" + x + "]";
		}

	}
}
