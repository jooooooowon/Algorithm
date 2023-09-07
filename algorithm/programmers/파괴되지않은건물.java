package Algorithm.algorithm.programmers;

public class 파괴되지않은건물 {

	// 누적합을 이용하여 문제를 푼다.
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		// 어느 부분의 시작부터 끝까지의 누적합을 편하게 구하기 위해서 + 1을 해준다.
		// 예를 들면 1 ~ 5에 2를 모두 더하고 싶다면
		// index 1에 2를 더하고 6에 -2를 더한 후 누적합을 한다.
		// 만약 여러 가지 값들이 어떤 범위에 대해 계속 더해진다면
		// 시작 index에 더할 값을 더하고, 마지막 인덱스 + 1에 더할 값 * (-1)을 더한다.
		// 누적합을 한다.
		
		int[][] temp = new int[board.length + 1][board[0].length + 1];
		for (int i = 0; i < skill.length; i++) {
			int type = skill[i][0];
			int r1 = skill[i][1];
			int c1 = skill[i][2];
			int r2 = skill[i][3];
			int c2 = skill[i][4];
			int degree = skill[i][5];
			if (type == 1) {
				degree *= -1;
			}
			// 만약 2차원이라면 r1,c1과 r2 + 1, c2 + 1에 더할 값을 더하고
			// r1,c2 + 1과 r2, c1에 더할 값*(-1)을 더한다.
			temp[r1][c1] += degree;
			temp[r1][c2 + 1] -= degree;
			temp[r2 + 1][c1] -= degree;
			temp[r2 + 1][c2 + 1] += degree;
		}
		
		
		// 가로 세로 한 번씩 누적합 해준다.
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length - 1; j++) {
				temp[i][j + 1] += temp[i][j];
			}
		}
		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				temp[i + 1][j] += temp[i][j];
			}
		}

		
		// 완성된 누적합을 원래의 배열에 더해준다.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] += temp[i][j];
				if (board[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}
