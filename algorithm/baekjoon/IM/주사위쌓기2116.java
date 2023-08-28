package Algorithm.algorithm.baekjoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위쌓기2116 {
	static int[][] arr;
	static int[] pairArr = {5,3,4,1,2,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][6];
		StringTokenizer st;
		for (int square = 0; square < n; square++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				arr[square][i] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		max = Math.max(max, make(0, 5, 0));
		max = Math.max(max, make(5, 0, 0));
		max = Math.max(max, make(1, 3, 0));
		max = Math.max(max, make(3, 1, 0));
		max = Math.max(max, make(2, 4, 0));
		max = Math.max(max, make(4, 2, 0));
		
		System.out.println(max);
	}

	private static int make(int bottom, int top, int count) {
		int max = 0;
		for(int i = 0 ; i < 6 ; i++) {
			if(bottom == i || top == i) {
				continue;
			}
			max = Math.max(max, arr[count][i]);
		}
		if(count == arr.length - 1) {
			return max;
		}
		int idx = 0;
		for(int i = 0 ; i < 6 ; i++) {
			if(arr[count + 1][i] == arr[count][top]) {
				idx = i;
			}
		}
		return max + make(idx,pairArr[idx],count+1);
	}
}
