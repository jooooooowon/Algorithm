package Algorithm.algorithm.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3_13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		int[] chk = new int[200000];
		Arrays.fill(chk, Integer.MAX_VALUE);
		chk[n] = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now * 2 < 200000) {
				if (chk[now * 2] > chk[now]) {
					chk[now * 2] = chk[now];
					queue.offer(now * 2);
				}
				if (chk[now + 1] > chk[now] + 1) {
					chk[now + 1] = chk[now] + 1;
					queue.offer(now + 1);
				}
			}
			if (now - 1 >= 0) {
				if (chk[now - 1] > chk[now] + 1) {
					chk[now - 1] = chk[now] + 1;
					queue.offer(now - 1);
				}
			}
		}
		System.out.println(chk[k]);
	}
}
