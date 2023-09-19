package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWProblemSolve1952수영장 {
	static int min;
	static int[] prices;
	static int[] months;
	static boolean[] chk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			prices = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			months = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				months[i] = Integer.parseInt(st.nextToken());
			}
			min = prices[3];
			chk = new boolean[13];
			dfs(1, 0);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int m, int sum) {
		if (m > 12) {
			min = Math.min(min, sum);
			return;
		}

		int temp = 0;
		temp += months[m] * prices[0];
		dfs(m + 1, sum + temp);

		temp = prices[1];
		dfs(m + 1, sum + temp);
		
		temp = prices[2];
		dfs(m + 3, sum + temp);
		
	}
}
