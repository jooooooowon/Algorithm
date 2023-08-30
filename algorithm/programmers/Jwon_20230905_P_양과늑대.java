package Algorithm.algorithm.programmers;

import java.util.Arrays;

public class Jwon_20230905_P_양과늑대 {
	public static int solution(int[] info, int[][] edges) {
		int answer = 0;
		int n = info.length;
		// 0 : left, 1 : right
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], -1);
		}
		for (int i = 0; i < n; i++) {
			int from = edges[i][0];
			int to = edges[i][0];
			if (arr[i][0] == -1) {
				arr[from][0] = to;
			} else {
				arr[from][1] = to;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

	}
}
