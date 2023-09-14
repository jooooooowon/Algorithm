package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 수들의합4_2015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 1; i < n; i++) {
			arr[i] += arr[i - 1];
		}

		HashMap<Long, Integer> map = new HashMap<>();
		long count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == k) {
				count++;
				long cnt = arr[i] - (long) k;
				if (map.containsKey(cnt)) {
					count += map.get(cnt);
				}
			} else {
				long cnt = arr[i] - (long) k;
				if (map.containsKey(cnt)) {
					count += map.get(cnt);
				}
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(count);
	}
}
