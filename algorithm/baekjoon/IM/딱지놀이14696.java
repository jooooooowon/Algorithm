package Algorithm.algorithm.baekjoon.IM;

import java.util.Scanner;

public class 딱지놀이14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int round = sc.nextInt();
		for (int roundCnt = 0; roundCnt < round; roundCnt++) {
			int[] arrA = new int[5];
			int[] arrB = new int[5];
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				arrA[sc.nextInt()]++;
			}
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				arrB[sc.nextInt()]++;
			}
			String str = "D";
			for (int i = 4; i > 0; i--) {
				if (arrA[i] > arrB[i]) {
					str = "A";
					break;
				} else if (arrB[i] > arrA[i]) {
					str = "B";
					break;
				}
			}
			System.out.println(str);
		}
	}
}
