package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반1486 {
	static int[] arr;
	static boolean[] chk;
	static int towerHeight;
	static int n;
	static int b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr = new int[n];
			chk = new boolean[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			towerHeight = Integer.MAX_VALUE;
			combination(0, 0);

			sb.append("#").append(testCase).append(" ").append(towerHeight - b).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int index, int sum) {
		if (sum >= towerHeight) {
			return;
		}
		if (sum >= b) {
			towerHeight = sum;
			return;
		}
		if (index == n) {
			return;
		}
		combination(index + 1, sum + arr[index]);
		combination(index + 1, sum);
	}
}
