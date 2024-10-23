package Algorithm.algorithm.programmers.in_2022_2023;

import java.util.*;

public class 네트워크 {

	public int solution(int n, int[][] computers) {
		int answer = 0;
		ArrayList<Integer>[] list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (j == i) {
					continue;
				}
				if (computers[i][j] == 1) {
					list[i].add(j);
					list[j].add(i);
				}
			}
		}
		boolean[] chk = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (chk[i]) {
				continue;
			}
			answer++;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			chk[i] = true;
			while (!queue.isEmpty()) {
				int now = queue.poll();

				if (list[now].size() > 0) {
					for (int next : list[now]) {
						queue.offer(next);
						if (list[next].indexOf(now) != -1) {
							list[next].remove(list[next].indexOf(now));
						}
						chk[next] = true;
					}
				}
			}
		}

		return answer;
	}

}
