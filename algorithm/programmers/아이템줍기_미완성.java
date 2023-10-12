package Algorithm.algorithm.programmers;

public class 아이템줍기_미완성 {
	static int[][][] map;
	static int answer;

	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		// 0 : 세로, 1 : 가로
		map = new int[51][51][2];
		for (int i = 0; i < rectangle.length; i++) {
			int leftX = rectangle[i][0];
			int leftY = rectangle[i][1];
			int rightX = rectangle[i][2];
			int rightY = rectangle[i][3];
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
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < 51; y++) {
			for (int x = 0; x < 51; x++) {
				if (map[y][x][0] == 1 || map[y][x][1] == 1) {
					sb.append("o");
				} else {
					sb.append("x");
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		answer = 200;
		for (int i = 0; i < 2; i++) {
			dfs(characterX, characterY, itemX, itemY, 0, i);
		}
		return answer;
	}

	// 하 상 우 좌
	static int[] dirY = { 1, -1, 0, 0 };
	static int[] dirX = { 0, 0, 1, -1 };

	private static void dfs(int characterX, int characterY, int itemX, int itemY, int count, int direction) {
		if (characterX == itemX && characterY == itemY) {
			answer = Math.min(count, answer);
			return;
		}
		if (direction == 0) {
			int index = 0;
			int nextY = characterY + dirY[index];
			int nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][0] == 1) {
				map[nextY][nextX][0] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 0);
				map[nextY][nextX][0] = 1;
			}
			index = 1;
			nextY = characterY + dirY[index];
			nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][0] == 1) {
				map[nextY][nextX][0] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 0);
				map[nextY][nextX][0] = 1;
			}
			index = 2;
			nextY = characterY + dirY[index];
			nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][1] == 1) {
				map[nextY][nextX][1] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 1);
				map[nextY][nextX][1] = 1;
			}
			index = 3;
			nextY = characterY + dirY[index];
			nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][1] == 1) {
				map[nextY][nextX][1] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 1);
				map[nextY][nextX][1] = 1;
			}
		} else {
			int index = 2;
			int nextY = characterY + dirY[index];
			int nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][1] == 1) {
				map[nextY][nextX][1] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 1);
				map[nextY][nextX][1] = 1;
			}
			index = 3;
			nextY = characterY + dirY[index];
			nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][1] == 1) {
				map[nextY][nextX][1] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 1);
				map[nextY][nextX][1] = 1;
			}
			index = 0;
			nextY = characterY + dirY[index];
			nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][0] == 1) {
				map[nextY][nextX][0] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 0);
				map[nextY][nextX][0] = 1;
			}
			index = 1;
			nextY = characterY + dirY[index];
			nextX = characterX + dirX[index];
			if (nextY >= 0 && nextY < 51 && nextX >= 0 && nextY < 51 && map[nextY][nextX][0] == 1) {
				map[nextY][nextX][0] = 2;
				dfs(nextX, nextY, itemX, itemY, count + 1, 0);
				map[nextY][nextX][0] = 1;
			}
		}
	}

	public static void main(String[] args) {
		int[][] rectangle1 = { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
		System.out.println(solution(rectangle1, 1, 3, 7, 8));
		int[][] rectangle2 = { { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
	}
}
