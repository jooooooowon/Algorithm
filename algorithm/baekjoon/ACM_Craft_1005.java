package Algorithm.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft_1005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= test; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] delay = new int[n + 1];
			int[] cnt = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < delay.length; i++) {
				delay[i] = Integer.parseInt(st.nextToken());
			}

			ArrayList<Integer>[] list = new ArrayList[n + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				cnt[to]++;
			}
			int w = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] result = new int[n + 1];
			for (int i = 1; i < cnt.length; i++) {
				if (cnt[i] == 0) {
					result[i] = delay[i];
					queue.offer(i);
				}
			}

			
			while (!queue.isEmpty()) {
				int now = queue.poll();
				if (now == w) {
					break;
				}
				for (int next : list[now]) {
					cnt[next]--;
					result[next] = Math.max(result[next], delay[next] + result[now]);
					if (cnt[next] == 0) {
						queue.offer(next);
					}
				}
			}
			sb.append(result[w]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
