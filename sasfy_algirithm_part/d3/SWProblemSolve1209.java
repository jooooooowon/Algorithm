package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 0 ; testCase < 10 ; testCase++) {
			int test = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < 100 ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i = 0 ; i < 100 ; i++) {
				int sumX = 0;
				int sumY = 0;
				for(int j = 0 ; j < 100 ; j++) {
					sumY += arr[i][j];
					sumX += arr[j][i];
				}
				max = Math.max(max, Math.max(sumX, sumY));
			}
			int sumDia = 0;
			for(int i = 0,j = 0 ; i < 100 ; i++, j++) {
				sumDia += arr[i][j];
			}
			max = Math.max(max, sumDia);

			sumDia = 0;
			for(int i = 0,j = 99 ; i < 100 ; i++, j--) {
				sumDia += arr[i][j];
			}
			max = Math.max(max, sumDia);
			
			sb.append("#").append(test).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
