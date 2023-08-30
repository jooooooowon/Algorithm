package Algorithm.sasfy_algirithm_part.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거다이어트5215 {
	static int[] flavors;
	static int[] cal;
	static int n;
	static int l;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			flavors = new int[n];
			cal = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				flavors[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			combination(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void combination(int start, int calSum, int flavorSum) {
		if(calSum > l) {
			return ;
		}
		max = Math.max(flavorSum, max);
		
		for(int i = start ; i < n ; i++) {
			combination(i+1, calSum + cal[i], flavorSum + flavors[i]);
		}
	}
}
