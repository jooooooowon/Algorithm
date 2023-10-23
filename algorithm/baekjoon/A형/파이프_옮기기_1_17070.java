package Algorithm.algorithm.baekjoon.A형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프_옮기기_1_17070 {
	static Pipe pipe;
	static boolean[][] arr;
	static int n;
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n + 2][n + 2];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				if (Integer.parseInt(st.nextToken()) == 0) {
					arr[i][j] = true;
				}
			}
		}
		pipe = new Pipe(new Point(1, 1), new Point(2, 1));
		find();
		System.out.println(count);
	}

	// 0 : 가로, 1 : 대각선 , 2 : 세로
	static int[] dirX = { 1, 1, 0 };
	static int[] dirY = { 0, 1, 1 };

	private static void find() {
		Point start = pipe.start;
		Point end = pipe.end;
		if (end.y == n && end.x == n) {
			count++;
			return;
		}
		arr[start.y][start.x] = false;
		arr[end.y][end.x] = false;
		StringBuilder sb = new StringBuilder();
		for (boolean[] tempArr : arr) {
			for (boolean temp : tempArr) {
				if (temp) {
					sb.append("o");
				} else {
					sb.append("x");
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println(pipe.toString());
		// 대각선일 때
		if (pipe.dir == 1) {
			// 가로로
			if (arr[end.y][end.x + 1]) {
				pipe.setEnd(new Point(end.x, end.y - 1));
				find();
			}
			// 세로로
			if (arr[end.y + 1][end.x]) {
				pipe.setEnd(new Point(end.x - 1, end.y));
				find();
			}
			// 대각선으로
			if (arr[end.y + 1][end.x] && arr[end.y][end.x + 1] && arr[end.y + 1][end.x + 1]) {
				pipe.start.y++;
				pipe.start.x++;
				pipe.setEnd(new Point(end.x + 1, end.y + 1));
				find();
				pipe.start.y--;
				pipe.start.x--;
			}
		} else if (pipe.dir == 0) {
			// 가로로
			if (arr[end.y][end.x + 1]) {
				pipe.start.x++;
				pipe.setEnd(new Point(end.x + 1, end.y));
				find();
				pipe.start.x--;
			}
			// 대각선으로
			if (arr[end.y + 1][end.x] && arr[end.y][end.x + 1] && arr[end.y + 1][end.x + 1]) {
				pipe.setEnd(new Point(end.x, end.y + 1));
				find();
			}
		} else if (pipe.dir == 2) {
			// 세로로
			if (arr[end.y + 1][end.x]) {
				pipe.start.y++;
				pipe.setEnd(new Point(end.x, end.y + 1));
				find();
				pipe.start.y--;
			}
			// 대각선으로
			if (arr[end.y + 1][end.x] && arr[end.y][end.x + 1] && arr[end.y + 1][end.x + 1]) {
				pipe.setEnd(new Point(end.x + 1, end.y));
				find();
			}
		}
		arr[end.y][end.x] = true;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	static class Pipe {
		Point start;
		Point end;
		// 0 : 가로, 1 : 대각선 , 2 : 세로
		int dir = 0;

		public Pipe() {

		}

		public Pipe(Point start, Point end) {
			super();
			this.start = start;
			this.end = end;
		}

		public void setEnd(Point end) {
			this.end = end;
			// 가로
			if (end.y == start.y && end.x == start.x + 1) {
				dir = 0;
			}
			// 대각선
			if (end.y == start.y + 1 && start.x == end.x + 1) {
				dir = 1;
			}
			// 세로
			if (end.y == start.y + 1 && start.x == end.x) {
				dir = 2;
			}
		}

		@Override
		public String toString() {
			return "Pipe [start=" + start.toString() + ", end=" + end.toString() + ", dir=" + dir + "]";
		}

	}
}
