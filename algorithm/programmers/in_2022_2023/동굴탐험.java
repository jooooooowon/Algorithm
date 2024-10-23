package Algorithm.algorithm.programmers.in_2022_2023;

import java.util.*;

public class 동굴탐험 {
	public boolean solution(int n, int[][] path, int[][] order) {
		boolean answer = true;
		ArrayList<Integer>[] list = new ArrayList[n];
		int[] newOrder = new int[n];
		boolean[] chk = new boolean[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < path.length; i++) {
			int from = path[i][0];
			int to = path[i][1];
			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 0; i < order.length; i++) {
			int from = order[i][0];
			int to = order[i][1];
			if (to == 0) {
				return false;
			}
			newOrder[from] = to;
			chk[to] = true;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = true;
		HashSet<Integer> set = new HashSet<>();
		while (!queue.isEmpty()) {
			int now = queue.poll();
			set.add(now);
			for (int next : list[now]) {

				if (!chk[next] && !visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}

				if (!chk[next] && newOrder[next] != 0) {
					if (!chk[newOrder[next]]) {
						visited[newOrder[next]] = true;
						queue.offer(newOrder[next]);
						newOrder[next] = 0;
					} else {
						chk[newOrder[next]] = false;
						newOrder[next] = 0;
					}
				}
				chk[next] = false;
			}
		}
		if (set.size() != n) {
			answer = false;
		}

		return answer;
	}
}
