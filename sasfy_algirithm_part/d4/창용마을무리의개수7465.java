package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 창용마을무리의개수7465 {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
//			System.out.println("before : " + Arrays.toString(arr));
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				makeUnion(num1,num2);
			}
			int count = 0;
//			System.out.println("after : " + Arrays.toString(arr));
			for (int i = 1; i <= n; i++) {
				if (arr[i] == i) {
					count++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void makeUnion(int num1, int num2) {
		int from = find(num1);
		int to = find(num2);
		arr[from] = arr[to];
	}
	private static int find(int num) {
		if(arr[num] == num) {
			return num;
		}
		return find(arr[num]);
	}
}
