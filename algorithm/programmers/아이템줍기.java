package Algorithm.algorithm.programmers;

import java.util.*;

public class 아이템줍기 {

	static int[][][] map;
	static int answer;

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		// 0 : 세로, 1 : 가로
		// 선은 1 채워져있는 면은 2로 채운다.
		// 만약 0이라면 1을 채워 선을 그리고, 2가 있는 곳이라면 어느 사각형의 내부이므로 1을 그리지 않는다.
		map = new int[101][101][2];
		for (int i = 0; i < rectangle.length; i++) {
			int leftX = rectangle[i][0] * 2;
			int leftY = rectangle[i][1] * 2;
			int rightX = rectangle[i][2] * 2;
			int rightY = rectangle[i][3] * 2;
			for (int y = leftY; y <= rightY; y++) {
				if (map[y][leftX][0] != 2) {
					map[y][leftX][0] = 1;
				}
				if (map[y][rightX][0] != 2) {
					map[y][rightX][0] = 1;
				}
			}
			for (int x = leftX; x <= rightX; x++) {
				if (map[leftY][x][1] != 2) {
					map[leftY][x][1] = 1;
				}
				if (map[rightY][x][1] != 2) {
					map[rightY][x][1] = 1;
				}
			}
			for (int y = leftY + 1; y < rightY; y++) {
				for (int x = leftX + 1; x < rightX; x++) {
					map[y][x][0] = 2;
					map[y][x][1] = 2;
				}
			}
		}
		answer = 100000;
		Queue<Point> queue = new LinkedList<>();
		// 0 : 세로, 1 : 가로
		// 안에 내부를 곱해준 채로 넣어준다.
		// 그냥 넣을 경우 4개의 사각형이 들어올 때 내부에 접근할 수 없는 사각형 선이 생기는데
		// bfs시 접근할 수 있다.
		// 여러 조건을 걸어 해결할 수도 있지만, 도형의 내부를 2배로 늘려 거리가 1보다 크게 만들어 아예 접근을 하지 못하게 만들었다.
		queue.offer(new Point(characterX * 2, characterY * 2, 0));
		queue.offer(new Point(characterX * 2, characterY * 2, 1));
		boolean[][] visited = new boolean[101][101];
		visited[characterY * 2][characterX * 2] = true;
		int[][] answerMatrix = new int[101][101];

		while (!queue.isEmpty()) {
			Point now = queue.poll();
			int temp = answerMatrix[now.y][now.x];
			if (now.y == itemY * 2 && now.x == itemX * 2) {
				break;
			}
			if (now.dir == 0) {
				int index = 2;
				int nextY = now.y + dirY[index];
				int nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][1] == 1 && map[now.y][now.x][1] == 1) {
					queue.offer(new Point(nextX, nextY, 1));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
				index = 3;
				nextY = now.y + dirY[index];
				nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][1] == 1 && map[now.y][now.x][1] == 1) {
					queue.offer(new Point(nextX, nextY, 1));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
				index = 0;
				nextY = now.y + dirY[index];
				nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][0] == 1 && map[now.y][now.x][0] == 1) {
					queue.offer(new Point(nextX, nextY, 0));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
				index = 1;
				nextY = now.y + dirY[index];
				nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][0] == 1 && map[now.y][now.x][0] == 1) {
					queue.offer(new Point(nextX, nextY, 0));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
			} else {
				int index = 0;
				int nextY = now.y + dirY[index];
				int nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][0] == 1 && map[now.y][now.x][0] == 1) {
					queue.offer(new Point(nextX, nextY, 0));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
				index = 1;
				nextY = now.y + dirY[index];
				nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][0] == 1 && map[now.y][now.x][0] == 1) {
					queue.offer(new Point(nextX, nextY, 0));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
				index = 2;
				nextY = now.y + dirY[index];
				nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][1] == 1 && map[now.y][now.x][1] == 1) {
					queue.offer(new Point(nextX, nextY, 1));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
				index = 3;
				nextY = now.y + dirY[index];
				nextX = now.x + dirX[index];
				if (nextY >= 0 && nextY < 101 && nextX >= 0 && nextX < 101 && !visited[nextY][nextX]
						&& map[nextY][nextX][1] == 1 && map[now.y][now.x][1] == 1) {
					queue.offer(new Point(nextX, nextY, 1));
					visited[nextY][nextX] = true;
					answerMatrix[nextY][nextX] = temp + 1;
					continue;
				}
			}

		}
		answer = answerMatrix[itemY * 2][itemX * 2] / 2;
		return answer;
	}

	// 하 상 우 좌
	static int[] dirY = { 1, -1, 0, 0 };
	static int[] dirX = { 0, 0, 1, -1 };

	static class Point {
		int x;
		int y;
		int dir;

		public Point() {

		}

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}

}
