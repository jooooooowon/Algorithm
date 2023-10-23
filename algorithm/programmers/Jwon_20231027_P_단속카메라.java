package Algorithm.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Jwon_20231027_P_단속카메라 {
	public static int solution(int[][] routes) {
		int answer = 0;
		Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		
		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(routes[i][j] + " ");
			}
			System.out.println();
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		solution(routes);
	}
	
}
