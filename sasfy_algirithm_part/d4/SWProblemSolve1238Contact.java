package Algorithm.sasfy_algirithm_part.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWProblemSolve1238Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= 10; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			ArrayList<Integer>[] arr = new ArrayList[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (arr[from] == null) {
					arr[from] = new ArrayList<>();
				}
				if (!arr[from].contains(to)) {
					arr[from].add(to);
				}

			}

			boolean[] chk = new boolean[101];
			int[] count = new int[101];
			Queue<Node> queue = new LinkedList<>();
			queue.offer(new Node(start, 1));
			chk[start] = true;
			int lastIndex = 1;
			while (!queue.isEmpty()) {
				Node now = queue.poll();
				lastIndex = now.level;
				if (arr[now.index] == null) {
					continue;
				}
				for (int next : arr[now.index]) {
					if (!chk[next]) {
						count[now.level + 1] = Math.max(count[now.level + 1], next);

						queue.offer(new Node(next, now.level + 1));
						chk[next] = true;
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(count[lastIndex]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Node {
		int index;
		int level;

		public Node(int index, int level) {
			super();
			this.index = index;
			this.level = level;
		}

	}
}
