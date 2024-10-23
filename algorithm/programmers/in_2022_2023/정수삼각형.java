package Algorithm.algorithm.programmers.in_2022_2023;

public class 정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;
		int n = triangle.length;
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				int tempI = i - 1;
				int tempJ = j;
				dp[i][j] = triangle[i][j];
				int temp = 0;
				if (tempI >= 0) {
					if (tempJ - 1 >= 0) {
						temp = Math.max(temp, dp[tempI][tempJ - 1]);
					}
					temp = Math.max(temp, dp[tempI][tempJ]);
				}
				dp[i][j] += temp;
				answer = Math.max(answer, dp[i][j]);
			}
		}

		return answer;
	}
}
