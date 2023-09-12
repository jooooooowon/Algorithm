package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이_0인_네_정수_7453 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		long[] b = new long[n];
		long[] c = new long[n];
		long[] d = new long[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Long.parseLong(st.nextToken());
			b[i] = Long.parseLong(st.nextToken());
			c[i] = Long.parseLong(st.nextToken());
			d[i] = Long.parseLong(st.nextToken());
		}
		int count = 0;
		Arrays.sort(c);
		Arrays.sort(d);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				long tempAB = a[i] + b[j];
				int start = 0;
				int end = n - 1;
				while (c[start] < d[end]) {
					long tempCD = c[start] + d[end];
					long tempSum = tempAB + tempCD;
					if (tempSum == 0) {
						count++;
					}
					if (tempSum > 0) {
						end--;
					} else {
						start++;
					}
				}
				start = 0;
				end = n - 1;
				while (d[start] < c[end]) {
					long tempCD = d[start] + c[end];
					long tempSum = tempAB + tempCD;
					if (tempSum == 0) {
						count++;
					}
					if (tempSum > 0) {
						end--;
					} else {
						start++;
					}
				}
			}
		}

		System.out.println(count);
	}
}
