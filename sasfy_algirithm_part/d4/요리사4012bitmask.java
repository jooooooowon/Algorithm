package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사4012bitmask {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int testCase = 1; testCase <= test; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < (1 << n); i++) {
				boolean[] temp = new boolean[n];
				boolean tf = false;
				for (int j = 0; j < n; j++) {
					if (Integer.bitCount(i) == n / 2) {
						if ((i & 1 << j) > 0) {
							temp[j] = true;
						}
						tf = true;
					}
				}
				if(tf) {
					int trueSum = 0;
					int falseSum = 0;
					for(int y = 0 ; y < n; y++) {
						for(int x = 0 ; x < n ; x++) {
							if(temp[y] && temp[x]) {
								trueSum += arr[y][x];
							}
							else if(!temp[y] && !temp[x]) {
								falseSum += arr[y][x];
							}
						} 
					}
					min = Math.min(min, Math.abs(trueSum - falseSum));
				}
			}
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
