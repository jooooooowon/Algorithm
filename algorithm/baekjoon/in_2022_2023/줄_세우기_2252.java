package Algorithm.algorithm.baekjoon.in_2022_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄_세우기_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		int[] cnt = new int[n + 1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			cnt[to]++;
		}
		ArrayList<Integer> result = new ArrayList<>();
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] == 0) {
				queue.offer(i);
				result.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : list[now]) {
				cnt[next]--;
				if (cnt[next] == 0) {
					result.add(next);
					queue.offer(next);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}
