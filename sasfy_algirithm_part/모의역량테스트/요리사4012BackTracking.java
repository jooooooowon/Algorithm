package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사4012BackTracking {
	static int[][] arr;
	static int n;
	static boolean[] chk;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			chk = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			combination(0,0);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void combination(int start, int count) {
		if(count == n/2) {
			int trueSum = 0;
			int falseSum = 0;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(chk[i] && chk[j]) {
						trueSum += arr[i][j];
					}
					if(!chk[i] && !chk[j]) {
						falseSum += arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(trueSum - falseSum));
			return ;
		}
		
		for(int i = start ; i < n ; i++) {
			if(!chk[i]) {
				chk[i] = true;
				combination(i+1, count+1);
				chk[i] = false;
			}
		}
	}
}
