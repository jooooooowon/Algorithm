package Algorithm.algorithm.programmers;

public class 파괴되지않은건물2 {

	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int[][] temp = new int[board.length][board[0].length + 1];
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
			for (int r = r1; r <= r2; r++) {
				temp[r][c1] += degree;
				temp[r][c2 + 1] -= degree;
			}
		}
		for (int i = 0; i < board.length; i++) {
			board[i][0] += temp[i][0];
			if (board[i][0] > 0) {
				answer++;
			}
			for (int j = 0; j < board[i].length - 1; j++) {
				temp[i][j + 1] += temp[i][j];
				board[i][j + 1] += temp[i][j + 1];
				if (board[i][j+1] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
	
}
