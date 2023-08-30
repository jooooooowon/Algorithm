package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합2817 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 0;
			for(int i = 0 ; i < (1 << arr.length) ; i++) {
				int sum = 0;
				for(int j = 0 ; j < arr.length; j++) {
					if((i & 1 << j) > 0) {
						sum += arr[j];
					}
				}
				if(sum == k) {
					count++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
