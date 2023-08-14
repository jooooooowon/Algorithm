package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int test = 1 ; test <= 10; test++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			for(int i = 2 ; i < n - 2 ; i++) {
				int max = 0;
				for(int j = i - 2 ; j <= i + 2; j++) {
					if(j != i) {
						max = Math.max(max, arr[j]);
					}
				}
				int temp = arr[i] - max;
				if(temp > 0) {
					sum += temp;
				}
			}
			
			sb.append("#").append(test).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
