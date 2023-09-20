package Algorithm.algorithm.baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jwon_20230922_B_3190_뱀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] apples = new boolean[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			apples[y][x] = true;
		}
		int l = sc.nextInt();
		char[] directionArr = new char[l];
		int[] timeArr = new int[l];
		for (int i = 0; i < l; i++) {
			int length = sc.nextInt();
			char dir = sc.next().charAt(0);
			timeArr[i] = length;
			directionArr[i] = dir;
		}

		// 우 하 좌 상,
		// 0 1 2 3
		int[] dirX = { 1, 0, -1, 0 };
		int[] dirY = { 0, 1, 0, -1 };

		Deque<Node> deque = new ArrayDeque<>();
		deque.offer(new Node(1, 1));
		int time = 1;
		int direction = 0;
		int index = 0;
		while (true) {
			Node node = deque.peekFirst();
			int tempX = dirX[direction] + node.x;
			int tempY = dirY[direction] + node.y;
			Node chkNode = new Node(tempY, tempX);
			if (tempX <= 0 || tempX > n || tempY <= 0 || tempY > n || deque.contains(chkNode)) {
				System.out.println(time);
				System.exit(0);
			}
			deque.addFirst(chkNode);
			if (apples[tempY][tempX]) {
				apples[tempY][tempX] = false;
			} else {
				deque.pollLast();
			}
			if (index < l && time == timeArr[index]) {
				if (directionArr[index] == 'L') {
					direction -= 1;
				} else {
					direction += 1;
				}
				direction += 4;
				direction %= 4;
				index++;
			}
			time++;
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
