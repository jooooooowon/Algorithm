package Algorithm.algorithm.softeer;

import java.io.*;
import java.util.*;

public class 우물_안_개구리_LV3 {

	static int[] people;
	static int[] weight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] weight = new int[n + 1];
		boolean[] strongest = new boolean[n + 1];
		Arrays.fill(strongest, true);
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < weight.length; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (weight[a] > weight[b]) {
				strongest[b] = false;
			} else if (weight[a] < weight[b]) {
				strongest[a] = false;
			} else {
				strongest[a] = false;
				strongest[b] = false;
			}
		}
		int result = 0;
		for (int i = 1; i < strongest.length; i++) {
			if (strongest[i]) {
				result++;
			}
		}
		System.out.println(result);
	}

}
