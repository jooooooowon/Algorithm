package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 암호_만들기_1759 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		char[] arr = new char[c];
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		ArrayList<String> list = new ArrayList<>();
		for (int bit = 1; bit < (1 << c); bit++) {
			if (Integer.bitCount(bit) == l) {
				boolean[] chk = new boolean[c];
				int aeiouCnt = 0;
				int notAeiouCnt = 0;
				StringBuilder tempSb = new StringBuilder();
				for (int i = 0; i < c; i++) {
					if ((bit & (1 << i)) > 0) {
						chk[i] = true;
						tempSb.append(arr[i]);
						if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
							aeiouCnt++;
						} else {
							notAeiouCnt++;
						}
					}
				}
				if (aeiouCnt >= 1 && notAeiouCnt >= 2) {
					list.add(tempSb.toString());
				}
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}
}
