package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWProblemSolve2112보호필름 {
	static int d;
	static int w;
	static int k;
	static int minCount;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int[][] arr = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			minCount = d;
			if(k == 1) {
				minCount = 0;
			}else {
				combination(arr, 0, 0);
			}
			sb.append("#").append(testCase).append(" ").append(minCount).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean chk(int[][] arr) {
		int[] chkList = new int[w];
		Arrays.fill(chkList, 1);
		boolean[] chkResult = new boolean[w];
		for (int i = 1; i < d; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i - 1][j] == arr[i][j]) {
					chkList[j]++;
					if (chkList[j] == k) {
						chkResult[j] = true;
					}
				} else {
					chkList[j] = 1;
				}
			}
		}
		for (int i = 0; i < w; i++) {
			if (!chkResult[i]) {
				return false;
			}
		}
		return true;
	}

	private static void combination(int[][] arr, int index, int count) {
		if(count >= minCount) {
			return ;
		}
		if (chk(arr)) {
			minCount = Math.min(minCount, count);
			return ;
		}
		if (index == d) {
			return ;
		}
		int[][] temp = new int[d][w];
		for(int i = 0 ; i < d ; i++) {
			for(int j = 0 ; j < w ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		combination(temp, index + 1, count);
		for(int i = 0 ; i < d ; i++) {
			for(int j = 0 ; j < w ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		Arrays.fill(temp[index], 1);
		combination(temp, index + 1, count + 1);
		for(int i = 0 ; i < d ; i++) {
			for(int j = 0 ; j < w ; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		Arrays.fill(temp[index], 0);
		combination(temp, index + 1, count + 1);
	}
}
