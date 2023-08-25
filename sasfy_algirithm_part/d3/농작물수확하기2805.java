package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물수확하기2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1 ; testCase <= test ; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				String str = br.readLine();
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			int sum = 0;
			for(int i = 0 ; i <= n/2 ; i++) {
				for(int j = n/2 - i; j <= n/2 + i; j++) {
					sum += arr[i][j];
				}
			}
			for(int i = n/2 + 1; i < n ; i++) {
				for(int j = i - n/2; j < n - (i - n/2) ; j++) {
					sum += arr[i][j];
				}
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
