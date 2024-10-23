package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이_0인_네_정수_7453 {
	// 중간에서 만나기 알고리즘 이용
	// 만약 두 배열의 합이 어느 결과 값이 나와야 한다면
	// 하나의 배열을 start로부터 시작하고 남은 하나의 배열은 end로부터 시작하는 투 포인터를 만들어서 한다.
	// 만약 하나라도 범위가 벗어난다면 (start > n || end < 0) 더 이상 찾는 것은 의미가 없기 때문에 그만 둔다.
	
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
		long[] arr1 = new long[n * n];
		long[] arr2 = new long[n * n];

		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr1[index] = a[i] + b[j];
				arr2[index] = c[i] + d[j];
				index++;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int start = 0;
		int end = n * n - 1;
		long count = 0;
		while (start < n*n && end >= 0) {
			if (arr1[start] + arr2[end] == 0) {
				long tempStart = arr1[start];
				long countStart = 0;
				while (start < n * n && arr1[start] == tempStart) {
					countStart++;
					start++;
				}
				long tempEnd = arr2[end];
				long countEnd = 0;
				while (end >= 0 && arr2[end] == tempEnd) {
					countEnd++;
					end--;
				}
				count += countStart * countEnd;
			} else if (arr1[start] + arr2[end] > 0) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(count);
	}
}
