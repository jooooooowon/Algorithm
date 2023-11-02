package Algorithm.algorithm.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리LV3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					// 만약 나보다 작은 값이 저장되어 있다면 그 값의 +1 값이 현재 내가 가능한 징검다리 갯수보다 큰 지 확인해준다.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 현재 징검다리 갯수를 result와 비교하여 가장 큰 값을 저장한다.
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
