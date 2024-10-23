package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 예산_2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int end = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}
		int max = Integer.parseInt(br.readLine());
		int start = 0;
		int answer = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			int temp = 0;
			for(int i = 0 ; i < n ; i++) {
				temp += Math.min(mid, arr[i]);
			}
			if(temp > max) {
				end = mid - 1;
			}else {
				answer = mid;
				start = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
