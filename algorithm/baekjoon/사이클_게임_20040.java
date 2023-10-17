package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클_게임_20040 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i;
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a) == find(b)) {
				System.out.println(i);
				System.exit(0);
			}
			union(a, b);
		}
		System.out.println(0);
	}

	private static void union(int a, int b) {
		int from = find(a);
		int to = find(b);
		
		arr[from] = find(to);
	}

	private static int find(int num) {
		if(arr[num] == num) {
			return num;
		}
		return arr[num] = find(arr[num]);
	}
}
