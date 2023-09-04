package Algorithm.sasfy_algirithm_part.모의역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWProblemSolve2112보호필름2 {
	static int d;
	static int w;
	static int k;
	static int minCount;
	static int[][] arr;

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
			arr = new int[d][w];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			minCount = d;
			for (int bit = 0; bit < 1 << d; bit++) {
				if (Integer.bitCount(bit) < minCount) {
					if (make(bit, bit, new int[d])) {
						minCount = Integer.bitCount(bit);
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(minCount).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean make(int bit, int tempBit, int[] tempArr) {
		if (tempBit == 0) {
			if (chk(tempArr, bit)) {
				return true;
			}
			return false;
		}
		boolean tf = false;
		int[] tempA = tempArr.clone();
		int[] tempB = tempArr.clone();
		for (int i = 0; i < d; i++) {
			if ((tempBit & 1 << i) > 0) {
				tempBit &= ~(1 << i);
				tempB[i] = 1;
				tf = make(bit, tempBit, tempA);
				if (tf) {
					return true;
				}
				tf = make(bit, tempBit, tempB);
				if (tf) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean chk(int[] tempArr, int bit) {
		int[][] temp = new int[d][w];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i].clone();
		}
		for (int i = 0; i < d; i++) {
			if ((bit & 1 << i) > 0) {
				Arrays.fill(temp[i], tempArr[i]);
			}
		}
		int[] chkList = new int[w];
		Arrays.fill(chkList, 1);
		boolean[] chkResult = new boolean[w];
		for (int i = 1; i < d; i++) {
			for (int j = 0; j < w; j++) {
				if (temp[i - 1][j] == temp[i][j]) {
					chkList[j]++;
				} else {
					chkList[j] = 1;
				}
				if (chkList[j] >= k) {
					chkResult[j] = true;
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

}
