package Algorithm.sasfy_algirithm_part.d3;

import java.util.Arrays;
import java.util.Scanner;

public class N_Queen2806 {
	static int count;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			int num = sc.nextInt();
			count = 0;
			arr = new int[num];
			nQueen(num, 0);
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void nQueen(int num, int idx) {
		// TODO Auto-generated method stub
		if (idx == num) {
			count++;
			return;
		}
		for (int i = 1; i <= num; i++) {
			arr[idx] = i;
			boolean tf = true;
			for (int j = 0; j < idx; j++) {
				if (arr[idx] == arr[j] || Math.abs(idx - j) == Math.abs(arr[idx] - arr[j])) {
					tf = false;
					break;
				}
			}

			if (tf) {
				nQueen(num, idx + 1);
			}
		}
	}
}
