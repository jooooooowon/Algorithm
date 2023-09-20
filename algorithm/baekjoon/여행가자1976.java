package Algorithm.algorithm.baekjoon;

import java.util.Scanner;

public class 여행가자1976 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int num = sc.nextInt();
				if (num == 1) {
					unionMake(i, j);
				}
			}
		}
		int[] plan = new int[m];
		for (int i = 0; i < m; i++) {
			plan[i] = sc.nextInt();
		}
		int chk = plan[0];
		boolean tf = true;
		for (int i = 0; i < m; i++) {
			if (find(chk) != find(plan[i])) {
				tf = false;
				break;
			}
		}
		if (tf) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static void unionMake(int i, int j) {
		int from = find(i);
		int to = find(j);
		arr[from] = arr[to];
	}

	private static int find(int num) {
		if (arr[num] == num) {
			return num;
		}
		return arr[num] = find(arr[num]);
	}
}
