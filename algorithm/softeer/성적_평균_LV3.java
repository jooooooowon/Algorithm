package Algorithm.algorithm.softeer;

import java.io.*;
import java.util.*;

public class 성적_평균_LV3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 여기까지 입력값 받고,
		
		// 누적합 해준다.
		for (int i = 2; i < n + 1; i++) {
			arr[i] += arr[i - 1];
		}
		
		// start ~ end 사이의 합만 알면 되는 문제로, end까지 더한 값에서 start - 1까지 더한 값을 빼주면
		// start ~ end 사이의 합이 구해진다.
		// 이 값을 end - start + 1 (갯수)로 나눠준다.
		StringBuilder sb = new StringBuilder();
		for (int count = 0; count < k; count++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int size = end - start + 1;

			double avg = (arr[end] - arr[start - 1]) / (double) size;
			sb.append(String.format("%.2f\n", avg));
			// System.out.printf("%.2f\n",avg);
		}
		System.out.println(sb.toString());
	}
}
