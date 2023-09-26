package Algorithm.algorithm.baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 문제집1766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] startArr = new int[n + 1];
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			if (list[from] == null) {
				list[from] = new ArrayList<>();
			}
			list[from].add(to);
			startArr[to]++;
		}
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (startArr[i] == 0) {
				pQueue.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!pQueue.isEmpty()) {
			int from = pQueue.poll();
			sb.append(from).append(" ");
			if (list[from] != null) {
				for (int next : list[from]) {
					startArr[next]--;
					if (startArr[next] == 0) {
						pQueue.offer(next);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
