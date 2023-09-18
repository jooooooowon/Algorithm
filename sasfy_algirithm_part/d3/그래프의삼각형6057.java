package Algorithm.sasfy_algirithm_part.d3;

import java.util.Scanner;

public class 그래프의삼각형6057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test; testCase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean[][] arr = new boolean[n+1][n+1];
			for(int i = 0 ; i < m ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = true;
			}
			
			int count = 0;
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(arr[i][j]) {
						for(int k = 1 ; k <= n ; k++) {
							if(arr[j][k] && arr[i][k]) {
								count++;
							}
						}
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	
	}
}
