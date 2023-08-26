package Algorithm.algorithm.baekjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열DP2491 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 1;
		int max = dp[0];
		for(int i = 1 ; i < n ; i++) {
			if(arr[i] >= arr[i-1]) dp[i] = dp[i-1]+1;
			else dp[i] = 1;
			max = Math.max(dp[i], max);
		}
		
		dp[n-1] = 1;
		for(int i = n-2 ; i >= 0 ; i--) {
			if(arr[i] >= arr[i+1]) dp[i] = dp[i+1]+1;
			else dp[i] = 1;
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
		
	}	
	

}
